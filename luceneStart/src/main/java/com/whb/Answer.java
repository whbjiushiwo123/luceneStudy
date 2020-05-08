    package com.whb;

    import java.util.ArrayList;
    import java.util.HashSet;
    import java.util.Set;

    public class Answer {
        private static ArrayList<String> tmpArr = new ArrayList<String>();
        public static void main(String[] args){
            String[] com = {"A","B","C","D","E","F"};
            /**
             * 如果要想在 n 个物品中，选择 k 个物品出来，选择的顺序无所谓，那么选择的方式总共有这么多种：
             * n! / (n-k)! * k!
             *
             *
             * 组合 ：6！/(6-2)！*2！=15
             * AB AC AD AE AF BC BD BE BF CD CE CF DE DF EF
             * 组合 ：6！/(6-3)！*3！= 6*5*4*3*2*1 /3*2*1* 3*2*1=20
             * ABC ABD ABE ABF  ACD ACE ACF ADE ADF AEF BCD BCE BCF BDE BDF BEF CDE CDF DEF
             * 组合 ：6！/(6-4)！*4！= 6*5*4*3*2*1 /2*1* 4*3*2*1 =15
             * ABCD ABCE ABCF ABDE ABDF ABCE ABCF ABEF ACDE ACDF ADEF BCDE BCDF BDEF CDEF
             * 组合 ：6！/(6-5)！*5！= 6*5*4*3*2*1 /1* 5*4*3*2*1 =6
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
         * 组合
         * 按一定的顺序取出元素，就是组合,元素个数[C arr.len 3]
         * @param index 元素位置
         * @param k 选取的元素个数
         * @param arr 数组
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
                    tmpArr.add(arr[i]); //tmpArr都是临时性存储一下
                    combine(i + 1,k - 1, arr); //索引右移，内部循环，自然排除已经选择的元素
                    tmpArr.remove((Object)arr[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
                }
            }else{
                return ;
            }
        }
}
