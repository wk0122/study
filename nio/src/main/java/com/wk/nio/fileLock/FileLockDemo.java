package com.wk.nio.fileLock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author wangkang
 * @Date 2022/3/15 14:10
 */
public class FileLockDemo {

    public static void main(String[] args) throws Exception {

        ByteBuffer byteBuffer = ByteBuffer.wrap("gfgf".getBytes());

        FileChannel fileChannel = FileChannel.open(
                Paths.get("/Users/admin/study/nio/src/main/resources/1.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.APPEND
        );
        fileChannel.position(fileChannel.size()-1);
        fileChannel.lock();
        fileChannel.write(byteBuffer);
        fileChannel.close();

        readFile();
    }

    private static void readFile() throws IOException {
        FileReader fileReader = new FileReader("/Users/admin/study/nio/src/main/resources/1.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = bufferedReader.readLine();
        while (s != null){
            System.out.println(s);
            s = bufferedReader.readLine();
        }
        fileReader.close();
        bufferedReader.close();
    }
}
