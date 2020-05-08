package com.whb.nio;

import java.io.*;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockDemo {
    public static void main(String[] args){
        FileOutputStream fos = null;
        FileChannel channel = null;
        File file = new File("D:"+File.separator+"test.txt");

        try {
            fos = new FileOutputStream(file);
            channel = fos.getChannel();
            /**
             * ock阻塞的方法，锁定范围可以随着文件的增大而增大，lock()默认是独占锁，lock(0L,Long.MAX_VALUE,true)是共享锁
             * tryLock非阻塞，未获得锁时，返回null，tryLock()默认是独占锁，tryLock(0L,Long.MAX_VALUE,true)为共享锁
             */
            FileLock lock = channel.lock();
            //FileLock lock = channel.tryLock();
            if(lock != null){
                System.out.println("获得文件锁！");
            }
            Thread.sleep(50000);
            lock.release();
            System.out.println("文件锁释放！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
