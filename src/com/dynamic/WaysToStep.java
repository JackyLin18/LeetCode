package com.dynamic;

/**
 * @ClassName WaysToStep
 * @Author Jacky
 * @Description 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * <p>
 * 示例2:
 * 输入：n = 5
 * 输出：13
 * <p>
 * 提示:
 * n范围在[1, 1000000]之间
 **/
public class WaysToStep {
    public int waysToStep(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int first = 1;
        int second = 2;
        int third = 4;
        int temp;
        for (int i = 3; i < n; i++) {
            temp = third;
            third = ((first + second) % 1000000007 + third) % 1000000007;
            first = second;
            second = temp;
        }
        return third;
    }
}
