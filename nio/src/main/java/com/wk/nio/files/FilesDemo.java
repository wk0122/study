package com.wk.nio.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author wangkang
 * @Date 2022/3/15 14:50
 */
public class FilesDemo {
    public static void main(String[] args) {

        //创建目录
//        Path path = Paths.get("/Users/admin/study/nio/src/main/resources/test");
//        try {
//            Path directory = Files.createDirectory(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //copy
//        Path path1 = Paths.get("/Users/admin/study/nio/src/main/resources/1.txt");
//        Path path2 = Paths.get("/Users/admin/study/nio/src/main/resources/test/1.txt");
//        try {
//            Files.copy(path1,path2, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //move
//        Path path1 = Paths.get("/Users/admin/study/nio/src/main/resources/1.txt");
//        Path path2 = Paths.get("/Users/admin/study/nio/src/main/resources/test/2.txt");
//        try {
//            Files.move(path1,path2, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //遍历
        Path root = Paths.get("/Users/admin/study/nio/src/main/resources");
        String fileToFind = File.separator + "1.txt";

        try {
            Files.walkFileTree(root,new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String s = file.toAbsolutePath().toString();

                    if (s.endsWith(fileToFind)){
                        System.out.println(s);
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
