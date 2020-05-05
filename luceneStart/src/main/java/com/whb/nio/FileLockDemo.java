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
             * ock�����ķ�����������Χ���������ļ������������lock()Ĭ���Ƕ�ռ����lock(0L,Long.MAX_VALUE,true)�ǹ�����
             * tryLock��������δ�����ʱ������null��tryLock()Ĭ���Ƕ�ռ����tryLock(0L,Long.MAX_VALUE,true)Ϊ������
             */
            FileLock lock = channel.lock();
            //FileLock lock = channel.tryLock();
            if(lock != null){
                System.out.println("����ļ�����");
            }
            Thread.sleep(50000);
            lock.release();
            System.out.println("�ļ����ͷţ�");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
