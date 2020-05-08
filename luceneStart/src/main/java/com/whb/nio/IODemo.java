package com.whb.nio;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IODemo {
    public static void main(String[] args){
        //io
        //mathod2();
        //nio
        //mathod3();
        //文件读取
        method4();
    }

    /**
     * 复制文件
     * 输入和输出都用缓冲流
     */
    private static void method4() {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream("H:"+File.separator+"1.rmvb");
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream("H:"+File.separator+"2.rmvb");
            bos = new BufferedOutputStream(fos);
            long l1 = System.currentTimeMillis();
            int len = 0;
            byte[] bytes = new byte[1024];
            while((len = fis.read(bytes)) !=-1){
                bos.write(bytes, 0, len);
            }
            System.out.println("复制所需要的时间："+(System.currentTimeMillis()-l1));

            //流未关闭的情况下，再次使用流
            if((len = fis.read(bytes))==-1){
                Class in =  fis.getClass();
                Method open0 = in.getDeclaredMethod("open0", String.class);
                open0.setAccessible(true);
                open0.invoke(fis,"H:"+File.separator+"1.rmvb");

            }
            while((len = fis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis != null){
                    bis.close();
                }
                if(fis != null){
                    fis.close();
                 }

                if(bos != null){
                    bos.close();
                }
                if(fos != null){
                    fos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
     * 传统IO
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
