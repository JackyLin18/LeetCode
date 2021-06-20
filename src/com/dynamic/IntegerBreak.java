package com.dynamic;

/**
 * @ClassName IntegerBreak
 * @Author Jacky
 * @Description
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 *
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 **/
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] f = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                max = Math.max(f[i - j] * j, j * (i - j));
            }
            f[i] = max;
        }
        return f[max - 1];
    }
}
