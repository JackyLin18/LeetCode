package com.array;

/**
 * @ClassName MaxArea
 * @Author Jacky
 * @Description
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 **/
public class MaxArea {
    public static void main(String[] args) {
        MaxArea o = new MaxArea();
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1,1};
//        int[] height = {4,3,2,1,4};
//        int[] height = {1, 2, 1};
        System.out.println(o.maxArea(height));
    }

    public int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0;
        int i = 0;
        int j = length - 1;
        while (j > i) {
            int iValue = height[i];
            int jValue = height[j];
            int temp = Math.min(iValue, jValue) * (j - i);
            maxArea = Math.max(maxArea, temp);
            if (iValue < jValue) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
