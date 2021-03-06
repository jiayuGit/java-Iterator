package com.interrator;

public class Code9 {
    public static void main(String[] ags) {
        int[] arr = new int[]{1, 3, 5, 2, 4, 6};
        setArr(arr);
        for (int a:arr
             ) {
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println(getSum(arr, 0, arr.length - 1));
        for (int a:arr
        ) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    /**
     * 数组中有不重复乱序的数,排序后可以变成连续的1-n
     * 时间复杂度O(N)
     * @param arr
     */
    public static void setArr(int[] arr){
        int num = 0;
        for(int i = 0;i<arr.length-1;i++){
            while(i+1!=arr[i]){//不对应序号的值放到对应的数组位置上,直到出现对应的数和下标时
                swap(arr,i,arr[i]-1);
            }
        }

    }

    private static void swap(int[] arr, int i, int i1) {
        arr[i]=arr[i]^arr[i1];
        arr[i1]=arr[i]^arr[i1];
        arr[i]=arr[i]^arr[i1];
    }

    /**
     * 求数组中正序序的个数
     * 归并排序思路
     * 时间复杂度O(N*log(N))
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int getSum(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int m = (l + r) / 2;
        return getSum(arr, l, m) + getSum(arr, m + 1, r) + addArr(arr, l, m, r);
    }

    /**
     * 归并两个数组段
     * 时间复杂度O(N)
     * @param arr
     * @param l
     * @param m
     * @param r
     * @return
     */
    private static int addArr(int[] arr, int l, int m, int r) {
        int sum = 0;
        int left = l;
        int k = 0;
        int right = m + 1;
        int[] dp = new int[r - l + 1];
        while (left <= m && right <= r) {
            if (arr[left] > arr[right]) {
                dp[k++] = arr[right++];
            } else {
                sum += arr[left] * (r - right + 1);
                dp[k++] = arr[left++];
            }
        }
        while (left <= m) {
            dp[k++] = arr[left++];
        }
        while (right <= r) {
            dp[k++] = arr[right++];
        }
        k = 0;
        for (int i = l; i < r + 1; i++) {
            arr[i] = dp[k++];
        }
        return sum;
    }
}
