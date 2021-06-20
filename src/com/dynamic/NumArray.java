package com.dynamic;

/**
 * @ClassName NumArray
 * @Author Jacky
 * @Description
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *     NumArray(int[] nums) 使用数组 nums 初始化对象
 *     int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 * 示例：
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 **/
public class NumArray {
    private final int[] nums;
    private int[] f;

    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums.length == 0) {
            return;
        }
        f = new int[nums.length];
        computeF();
    }

    // 状态方程：f(i) = f(i-1) + nums[i](i>=1) f(0) = nums[0]
    public void computeF() {
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = f[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (nums.length == 0) {
            return 0;
        }
        if (left == 0) {
            return f[right];
        } else {
            return f[right] - f[left - 1];
        }
    }
}
