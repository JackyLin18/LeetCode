package com;

import java.util.Arrays;

/**
 * @ClassName Rotate
 * @Author Jacky
 * @Description
 **/
public class Rotate {
    public static void main(String[] args) {
        Rotate o = new Rotate();
        int[] nums = {-1,-100,3,99};
        int k = 2;
        o.rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int length = nums.length;
        k %= length;
        int[] tempArray = new int[k];
        for (int i = 0; i < k; i++) {
            int temp = nums[length - k + i];
            tempArray[i] = temp;
        }
        for (int i = length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tempArray[i];
        }
    }
}