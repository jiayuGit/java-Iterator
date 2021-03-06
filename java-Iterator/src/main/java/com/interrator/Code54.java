package com.interrator;

public class Code54 {
    public static void main(String[] ags) {

        System.out.println(getInt(new char[]{'A','B','C','D'},"ACD"));
    }

    /**
     * 把对应字符转换成十进制数
     * @param cs
     * @param s
     * @return
     */
    public static int getInt(char[] cs ,String s){
        char[] res = s.toCharArray();
        int dp = 0;
        int k = 1;
        for(int i = res.length-1;i>=0;i--){
            dp +=(getIndex(cs,res[i])*k);
            k*=cs.length;
        }
        return dp;
    }
    private static int getIndex(char[] cs, char re) {
        for (int i = 0;i<cs.length;i++){
            if(cs[i]==re){
                return i+1;
            }
        }
        return -1;
    }
}
