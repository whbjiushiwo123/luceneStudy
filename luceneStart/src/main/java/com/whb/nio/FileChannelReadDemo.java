package com.whb.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadDemo {
    public static void main(String[] args){
        FileInputStream fis = null;
        FileChannel fc = null;
        File file = new File("D:"+File.separator+"test.txt");

        try {
            fis = new FileInputStream(file);
            fc = null;
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            fc =fis.getChannel();
            int data = -1;
            while((data = fc.read(byteBuffer))>0){
                System.out.println(new String(byteBuffer.array()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
