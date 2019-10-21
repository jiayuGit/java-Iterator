package com.interrator;

public class Code67 {
    public static void main(String[] ags) {
        int[] a = new int[]{1, 2, 3,4};
        int[] b = new int[]{3};

        System.out.println(getTopK(a, b,3));
    }
    /**
     * 获取两个有序数组中的第K大的数
     * 时间复杂度O(Log(N))
     * @param a
     * @param b
     * @param k
     * @return
     */
    public static Integer getTopK(int[] a, int[] b, int k) {
        if (a.length > b.length) {
            int[] s = a;
            a = b;
            b = s;
        }
        if (k < 1 || k > b.length+a.length) {
            return null;
        }
        if(k<=a.length){
            return getMedians(a,b,0,0,k);
        }else if(k>a.length&&k<=b.length){
            if(a[a.length-1]<b[k-1-a.length]){
                return b[k-1-a.length];
            }else {
                return getMedians(a,b,0,k-1-a.length+1,a.length);
            }
        }else if(k>b.length) {
            if(a[k-b.length-1 ]>b[b.length-1]){
                return a[k-b.length-1];
            }else if(a[a.length-1]<b[k-a.length-1]){
                return b[k-a.length-1];
            }else {
                int  n = a.length+b.length-k;
                return getMedians(a,b,a.length-1-n +1,b.length-1-n +1,n);
            }
        }
        return null;

    }

    private static Integer getMedians(int[] a, int[] b,int al,int bl ,int k  ) {

        int aleft = al;
        int bleft = bl;
        int aright = al+k-1;
        int bright = bl+k-1;
        while (aleft<aright&&bleft<bright){
            int m1 = (aleft+aright)/2;
            int m2 = (bleft+bleft)/2;
            int off  = (aright-aleft+1)&1^1;
            if(a[m1]>b[m2]){
                aright = m1;
                bleft = m2+off;
            }else if(a[m1]<b[m2]){
                aleft = m1+off;
                bleft = m2;
            }else {
                return a[m1];
            }
        }
        return Math.min(a[aleft],b[bleft]);
    }
}
