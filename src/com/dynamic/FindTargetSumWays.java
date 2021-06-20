package com.dynamic;

/**
 * @ClassName FindTargetSumWays
 * @Author Jacky
 * @Description
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例：
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 **/
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, target, 0);
    }

    // 递归
    public int find(int[] nums, int target, int index) {
        if (index == nums.length - 1) {
            if (nums[index] == target || nums[index] == -target) {
                if (nums[index] == 0) {
                    return 2;
                }
                return 1;
            } else {
                return 0;
            }
        }
        return find(nums, target - nums[index], index + 1) +
                find(nums, target + nums[index], index + 1);
    }
}
