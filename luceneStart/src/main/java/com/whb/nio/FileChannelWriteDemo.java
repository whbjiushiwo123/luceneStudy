package com.whb.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 */
public class FileChannelWriteDemo {
    public static void main(String[] args){

        String [] s = new String[]{"���",",","�ټ�!"};
        File file = new File("D:"+File.separator+"test.txt");
        FileOutputStream fos = null;
        FileChannel channel = null;
        try {
            fos = new FileOutputStream(file);
            channel = null;
            channel = fos.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            for(int i =0;i<s.length;i++){
                byteBuffer.put(s[i].getBytes());
            }
            /**
             * 	flip()������
             * 			��Buffer��дģʽ�л�����ģʽ
             * 			����flip()������position���0������limit���û�ԭ�ȵ�positionλ��
             * 			buf.flip()
             */
            byteBuffer.flip();
            channel.write(byteBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(channel != null){
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(fos != null){
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
