package com.interrator;

public class Code73 {
    /**
     * 打印逆序数对
     */
    public static int[] arr = {7,5,6,4};
    public static void main(String[] args) {
//        revSeq(arr);
        for(int i = 0;i<arr.length;i++){
            for (int j = i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    System.out.println(arr[i]+" "+arr[j]);
                }
            }
        }
    }
}
