package com.dynamic;

/**
 * @ClassName ClimbStairs
 * @Author Jacky
 * @Description
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 **/
public class ClimbStairs {
    // 公式：c(1)=1, c(2)=2...c(n)=c(n-1)+c(n-2)
    // 使用递归：会导致计算量冗余
    // 可以使用动态规划：借助辅助数组(需要额外的空间)/观察到只需要前两项即可计算
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int i = 3;
        int result = first + second;
        while (i < n) {
            first = second;
            second = result;
            result = first + second;
            i++;
        }
        return result;
    }
}
