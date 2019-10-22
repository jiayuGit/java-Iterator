package com.interrator;

public class Code68 {
    public static void main(String[] ags) {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{1, 3, 6, 8};
        System.out.println(getMedian(a, b));
//        System.out.println(getTopK(a, b,3));
    }

    /**
     * 在两个长度相等的有序数组中找上中位数
     * 时间复杂度O(Log(N))
     * @param a
     * @param b
     * @return
     */
    public static int getMedian(int[] a, int[] b) {
        int statr1 = 0;
        int statr2 = 0;
        int end1 = a.length - 1;
        int end2 = b.length - 1;
        while (statr1 < end1 && statr2 < end2) {
            int m1 = (statr1 + end1) / 2;
            int m2 = (statr2 + end2) / 2;
            int off = (((end1 - statr1 + 1) & 1) ^ 1);
            if (a[m1] > b[m2]) {
                end1 = m1;
                statr2 = m2 + off;
            } else if (a[m1] < b[m2]) {
                statr1 = m1 + off;
                end2 = m2;
            } else {
                return a[m1];
            }
        }
        return Math.min(a[statr1], b[statr2]);
    }
}
