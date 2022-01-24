package com.wk.sensitive.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * 敏感词处理工具 - DFA算法实现
 * @author wangkang
 * @Date 2022/1/24 16:49
 */
public class SensitiveWordUtil {

    private static final Logger logger = LoggerFactory.getLogger(SensitiveWordUtil.class);

    /**
     * 敏感词匹配规则
     */
    public static final int MinMatchTYpe = 1;      //最小匹配规则，如：敏感词库["中国","中国人"]，语句："我是中国人"，匹配结果：我是[中国]人
    public static final int MaxMatchType = 2;      //最大匹配规则，如：敏感词库["中国","中国人"]，语句："我是中国人"，匹配结果：我是[中国人]

    /**
     * 敏感词集合
     */
    public static HashMap sensitiveWordMap;

    /**
     * 初始化敏感词库，构建DFA算法模型
     *
     * @param bytes 敏感词库
     */
    private static synchronized void init(byte[] bytes) throws Exception {
        initSensitiveWordMap(readSensitiveWordFile(bytes));
    }

    /**
     * 初始化敏感词库，构建DFA算法模型
     *
     * @param sensitiveWordSet 敏感词库
     */
    private static void initSensitiveWordMap(Set<String> sensitiveWordSet) {
        //初始化敏感词容器，减少扩容操作
        sensitiveWordMap = new HashMap(sensitiveWordSet.size());
        String key;
        Map nowMap;
        Map<String, String> newWorMap;
        //迭代sensitiveWordSet
        Iterator<String> iterator = sensitiveWordSet.iterator();
        while (iterator.hasNext()) {
            //关键字
            key = iterator.next();
            nowMap = sensitiveWordMap;
            for (int i = 0; i < key.length(); i++) {
                //转换成char型
                char keyChar = key.charAt(i);
                //库中获取关键字
                Object wordMap = nowMap.get(keyChar);
                //如果存在该key，直接赋值，用于下一个循环获取
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<>();
                    //不是最后一个
                    newWorMap.put("isEnd", "0");
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (i == key.length() - 1) {
                    //最后一个
                    nowMap.put("isEnd", "1");
                }
            }
        }
    }

    /**
     * 判断文字是否包含敏感字符
     *
     * @param txt       文字
     * @param matchType 匹配规则 1：最小匹配规则，2：最大匹配规则
     * @return 若包含返回true，否则返回false
     */
    public static boolean contains(String txt, int matchType) {
        boolean flag = false;
        for (int i = 0; i < txt.length(); i++) {
            int matchFlag = checkSensitiveWord(txt, i, matchType); //判断是否包含敏感字符
            if (matchFlag > 0) {    //大于0存在，返回true
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 判断文字是否包含敏感字符
     *
     * @param txt 文字
     * @return 若包含返回true，否则返回false
     */
    public static boolean contains(String txt,byte[] bytes) {
        try {
            init(bytes);
        } catch (Exception e) {
            logger.error("初始化词库失败",e);
        }
        return contains(txt, MaxMatchType);
    }

    /**
     * 获取文字中的敏感词
     *
     * @param txt       文字
     * @param matchType 匹配规则 1：最小匹配规则，2：最大匹配规则
     * @return
     */
    public static Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordList = new HashSet<>();

        for (int i = 0; i < txt.length(); i++) {
            //判断是否包含敏感字符
            int length = checkSensitiveWord(txt, i, matchType);
            if (length > 0) {//存在,加入list中
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1;//减1的原因，是因为for会自增
            }
        }

        return sensitiveWordList;
    }

    /**
     * 获取文字中的敏感词
     *
     * @param txt 文字
     * @param bytes 词库
     * @return
     */
    public static Set<String> getSensitiveWord(String txt,byte[] bytes) {
        try {
            init(bytes);
        } catch (Exception e) {
            logger.error("初始化词库失败",e);
        }
        return getSensitiveWord(txt, MaxMatchType);
    }

    /**
     * 替换敏感字字符
     *
     * @param txt         文本
     * @param replaceChar 替换的字符，匹配的敏感词以字符逐个替换，如 语句：我爱中国人 敏感词：中国人，替换字符：*， 替换结果：我爱***
     * @param matchType   敏感词匹配规则
     * @return
     */
    public static String replaceSensitiveWord(String txt, char replaceChar, int matchType) {
        String resultTxt = txt;
        //获取所有的敏感词
        Set<String> set = getSensitiveWord(txt, matchType);
        Iterator<String> iterator = set.iterator();
        String word;
        String replaceString;
        while (iterator.hasNext()) {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }

        return resultTxt;
    }

    /**
     * 替换敏感字字符
     *
     * @param txt         文本
     * @param replaceChar 替换的字符，匹配的敏感词以字符逐个替换，如 语句：我爱中国人 敏感词：中国人，替换字符：*， 替换结果：我爱***
     * @return
     */
    public static String replaceSensitiveWord(String txt, char replaceChar) {
        return replaceSensitiveWord(txt, replaceChar, MaxMatchType);
    }

    /**
     * 替换敏感字字符
     *
     * @param txt        文本
     * @param replaceStr 替换的字符串，匹配的敏感词以字符逐个替换，如 语句：我爱中国人 敏感词：中国人，替换字符串：[屏蔽]，替换结果：我爱[屏蔽]
     * @param matchType  敏感词匹配规则
     * @return
     */
    public static String replaceSensitiveWord(String txt, String replaceStr, int matchType) {
        String resultTxt = txt;
        //获取所有的敏感词
        Set<String> set = getSensitiveWord(txt, matchType);
        Iterator<String> iterator = set.iterator();
        String word;
        while (iterator.hasNext()) {
            word = iterator.next();
            resultTxt = resultTxt.replaceAll(word, replaceStr);
        }

        return resultTxt;
    }

    /**
     * 替换敏感字字符
     *
     * @param txt        文本
     * @param replaceStr 替换的字符串，匹配的敏感词以字符逐个替换，如 语句：我爱中国人 敏感词：中国人，替换字符串：[屏蔽]，替换结果：我爱[屏蔽]
     * @param bytes 词库
     * @return
     */
    public static String replaceSensitiveWord(String txt, String replaceStr,byte[] bytes) {
        try {
            init(bytes);
        } catch (Exception e) {
            logger.error("初始化词库失败",e);
        }
        return replaceSensitiveWord(txt, replaceStr, MaxMatchType);
    }

    /**
     * 获取替换字符串
     *
     * @param replaceChar
     * @param length
     * @return
     */
    private static String getReplaceChars(char replaceChar, int length) {
        String resultReplace = String.valueOf(replaceChar);
        for (int i = 1; i < length; i++) {
            resultReplace += replaceChar;
        }

        return resultReplace;
    }

    /**
     * 检查文字中是否包含敏感字符，检查规则如下：<br>
     *
     * @param txt
     * @param beginIndex
     * @param matchType
     * @return 如果存在，则返回敏感词字符的长度，不存在返回0
     */
    private static int checkSensitiveWord(String txt, int beginIndex, int matchType) {
        //敏感词结束标识位：用于敏感词只有1位的情况
        boolean flag = false;
        //匹配标识数默认为0
        int matchFlag = 0;
        char word;
        Map nowMap = sensitiveWordMap;
        for (int i = beginIndex; i < txt.length(); i++) {
            word = txt.charAt(i);
            //获取指定key
            nowMap = (Map) nowMap.get(word);
            if (nowMap != null) {//存在，则判断是否为最后一个
                //找到相应key，匹配标识+1
                matchFlag++;
                //如果为最后一个匹配规则,结束循环，返回匹配标识数
                if ("1".equals(nowMap.get("isEnd"))) {
                    //结束标志位为true
                    flag = true;
                    //最小规则，直接返回,最大规则还需继续查找
                    if (MinMatchTYpe == matchType) {
                        break;
                    }
                }
            } else {//不存在，直接返回
                break;
            }
        }
        if (matchFlag < 2 || !flag) {//长度必须大于等于1，为词
            matchFlag = 0;
        }
        return matchFlag;
    }


    public static Set<String> readSensitiveWordFile(byte[] bytes) throws Exception{
        //存放文件内容的set集合
        Set<String> set = null;
        InputStreamReader read = new InputStreamReader(new ByteArrayInputStream(bytes),getFileCharset(bytes));
        try {
            //初始化set集合
            set = new HashSet<String>();
            //缓冲区读取流
            BufferedReader bufferedReader = new BufferedReader(read);

            //循环读取文件中内容，每次读取一行内容
            String txt = null;
            while((txt = bufferedReader.readLine()) != null){
                //读取文件，将文件内容放入到set中
                set.add(txt);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            read.close();     //关闭文件流
        }
        return set;
    }

    /**
     * Gets file charset.
     *
     * @param bytes the bytes
     * @return the file charset
     */
    public static String getFileCharset(byte[] bytes) {
        String DEFAULT_ENCODING = "UTF-8";
        org.mozilla.universalchardet.UniversalDetector detector =
                new org.mozilla.universalchardet.UniversalDetector(null);
        detector.handleData(bytes, 0, bytes.length);
        detector.dataEnd();
        String encoding = detector.getDetectedCharset();
        detector.reset();
        if (encoding == null) {
            encoding = DEFAULT_ENCODING;
        }
        return encoding;
    }

    public static void main(String[] args) {
        String path = Thread.currentThread().getContextClassLoader().getResource("sensitive.txt").getPath();
        File file = new File(path);
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            init(bos.toByteArray());
            String string = "太多的伤yuming感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。"
                    + "然后法轮功 我们的扮演的角色就是跟随着主人yum公的喜红客联盟 怒于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。"
                    + "然后法轮功 我们的扮演的角色就是跟随着主人yum公的喜红客联盟 怒哀20于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。"
                    + "然后法轮功 我们的扮演的角色就是跟随着主人yum公的喜红客联盟 怒哀20哀2015/4/16 20152015/4/16乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
                    + "关, 人, 流, 电, 发, 情, 太, 限, 法轮功, 个人, 经, 色, 许, 公, 动, 地, 方, 基, 在, 上, 红, 强, 自杀指南, 制, 卡, 三级片, 一, 夜, 多, 手机, 于, 自，"
                    + "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。";
            System.out.println(SensitiveWordUtil.getSensitiveWord(string,1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
