package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ThreeSum
 * @Author Jacky
 * @Description
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 **/
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum o = new ThreeSum();
        int[] nums = {0, 0, 0};
        System.out.println(o.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        sort(nums);
        int iTemp = nums[0];
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (i > 0 && iTemp == nums[i]) {
                continue;
            }
            iTemp = nums[i];
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    ArrayList<Integer> ns = new ArrayList<>();
                    ns.add(nums[i]);
                    ns.add(nums[j]);
                    ns.add(nums[k]);
                    result.add(ns);
                    int jTemp = nums[j];
                    int kTemp = nums[k];
                    while (j < length && jTemp == nums[j]) {
                        j++;
                    }
                    while (k < length && k > 0 && kTemp == nums[k]) {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    private void sort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i; j < length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
