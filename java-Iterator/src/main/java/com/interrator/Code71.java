package com.interrator;

import java.util.Scanner;

public class Code71 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<=n;i++){

            System.out.print(amount(n,i)+" ");
        }
    }

    /**
     * 数学公式C(N,n)   0<=n<=N
     *
     * @param a
     * @param b
     * @return
     */
    public static int amount( int a,int b) {
        int da=1;
        int xiao=1;
        //5！/(5-3)!
        for(int i=0;i<b;i++) {
            da=da*a;
            a--;
        }
        //3！
        for(;b>0;b--) {
            xiao=xiao*b;
        }
        return da/xiao;
    }
}
