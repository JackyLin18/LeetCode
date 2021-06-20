package com.array;

/**
 * @ClassName ThreeSumClosest
 * @Author Jacky
 * @Description
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 **/
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest o = new ThreeSumClosest();
        int[] nums = {1,1,1,1};
        int target = -100;
        System.out.println(o.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0]+nums[1]+nums[2];
        int length = nums.length;
        sort(nums);
        for (int i = 0; i < length - 1; i++) {
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                result = closest(target, result, temp);
                if (temp < target) {
                    j++;
                } else if (temp > target) {
                    k--;
                } else {
                    return temp;
                }
            }

        }
        return result;
    }

    private int closest(int target, int x, int y) {
        int sub1, sub2;
        if (target > x) {
            sub1 = target - x;
        } else {
            sub1 = x - target;
        }
        if (target > y) {
            sub2 = target - y;
        } else {
            sub2 = y - target;
        }
        return sub1 < sub2 ? x : y;
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
