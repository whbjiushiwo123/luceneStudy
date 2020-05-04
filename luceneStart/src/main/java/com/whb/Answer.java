    package com.whb;

    import java.util.ArrayList;
    import java.util.HashSet;
    import java.util.Set;

    public class Answer {
        private static ArrayList<String> tmpArr = new ArrayList<String>();
        public static void main(String[] args){
            String[] com = {"A","B","C","D","E","F"};
            /**
             * ���Ҫ���� n ����Ʒ�У�ѡ�� k ����Ʒ������ѡ���˳������ν����ôѡ��ķ�ʽ�ܹ�����ô���֣�
             * n! / (n-k)! * k!
             *
             *
             * ��� ��6��/(6-2)��*2��=15
             * AB AC AD AE AF BC BD BE BF CD CE CF DE DF EF
             * ��� ��6��/(6-3)��*3��= 6*5*4*3*2*1 /3*2*1* 3*2*1=20
             * ABC ABD ABE ABF  ACD ACE ACF ADE ADF AEF BCD BCE BCF BDE BDF BEF CDE CDF DEF
             * ��� ��6��/(6-4)��*4��= 6*5*4*3*2*1 /2*1* 4*3*2*1 =15
             * ABCD ABCE ABCF ABDE ABDF ABCE ABCF ABEF ACDE ACDF ADEF BCDE BCDF BDEF CDEF
             * ��� ��6��/(6-5)��*5��= 6*5*4*3*2*1 /1* 5*4*3*2*1 =6
             * ABCDE ABCDF ABCEF ABDEF ACDEF BCDEF
             * ABCDEF
             *
             */

            for(int k =2 ;k<=com.length;k++){
                if(k > com.length || com.length <= 0){
                    return ;
                }
                combine(0 ,k ,com);
            }


        }

        /**
         * ���
         * ��һ����˳��ȡ��Ԫ�أ��������,Ԫ�ظ���[C arr.len 3]
         * @param index Ԫ��λ��
         * @param k ѡȡ��Ԫ�ظ���
         * @param arr ����
         */
        public static void combine(int index,int k,String []arr) {
            if(k == 1){
                for (int i = index; i < arr.length; i++) {
                    tmpArr.add(arr[i]);
                    System.out.println(tmpArr.toString() + ",");
                    tmpArr.remove((Object)arr[i]);
                }
            }else if(k > 1){
                for (int i = index; i <= arr.length - k; i++) {
                    tmpArr.add(arr[i]); //tmpArr������ʱ�Դ洢һ��
                    combine(i + 1,k - 1, arr); //�������ƣ��ڲ�ѭ������Ȼ�ų��Ѿ�ѡ���Ԫ��
                    tmpArr.remove((Object)arr[i]); //tmpArr��Ϊ����ʱ�洢�ģ���һ������ҳ���͸��ͷſռ䣬�洢��һ��Ԫ�ؼ���ƴ�������
                }
            }else{
                return ;
            }
        }
}
