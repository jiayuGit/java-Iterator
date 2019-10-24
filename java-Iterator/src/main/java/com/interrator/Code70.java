package com.interrator;

public class Code70 {
    public static void main(String[] ags) {
        getStrin("a((bd)(hkl)o)");
    }

    /**
     * 在括号的字符翻转
     * 时间复杂度N^2
     *
     * @param s
     */
    public static void getStrin(String s) {
        char[] dp = s.toCharArray();
        dp = getSf(dp, 0, dp.length - 1);
        for (char a : dp
        ) {
            System.out.print(a);
        }
    }

    private static char[] getSf(char[] dp, int i, int j) {
        int left = i;
        while (left <= dp.length - 1) {
            if (dp[left] == '(') {
                dp = getSf(dp, ++left, j);
            } else {
                left++;
            }
        }
        if (i < 1) {
            return dp;
        }
        int right = getIndexRiget(dp, i, j);
        swapS(dp, i, right - 1);
        dp = deleteS(dp, i - 1, right);


        return dp;
    }

    private static char[] deleteS(char[] dp, int i, int right) {
        char[] res = new char[dp.length - 2];
        int n = 0;
        int k = 0;
        while (n < res.length) {
            if (k != i && k != right) {
                res[n] = dp[k];
                n++;
            }
            k++;
        }
        return res;
    }

    private static void swapS(char[] dp, int i, int j) {
        while (i <= j) {
            swap(dp, i, j);
            i++;
            j--;
        }
    }

    private static void swap(char[] dp, int i, int j) {
        char a = dp[i];
        dp[i] = dp[j];
        dp[j] = a;
    }

    private static int getIndexRiget(char[] dp, int i, int j) {
        while (i <= j) {
            if (dp[i] == ')') {
                return i;
            }
            i++;
        }
        return -1;
    }
}
