package com.whb.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IODemo {
    public static void main(String[] args){
        //io
        //mathod2();
        //nio
        mathod3();
    }

    private static void mathod3() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("D:"+File.separator+"test.txt","rw");
            FileChannel fc = raf.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = fc.read(byteBuffer);
            while(read != -1){
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    System.out.println((char)byteBuffer.get());
                }
                byteBuffer.compact();
                read = fc.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(raf != null){
                    raf.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * ´«Í³IO
     */
    public static void mathod2(){
        InputStream in = null;
        try {
            File file = new File("D:"+File.separator+"test.txt");

            in = new BufferedInputStream(new FileInputStream(file));
            byte[]bytes = new byte[1024];
            int byteRead = in.read(bytes);
            while(byteRead!=-1){
                for(int i=0;i<byteRead;i++){
                    System.out.println((char)bytes[i]);
                }
                byteRead = in.read(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
