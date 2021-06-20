package com;

import java.util.Arrays;

/**
 * @ClassName MoveZeroes
 * @Author Jacky
 * @Description
 **/
public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes o = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        o.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int i = 0, j = 0;
        while (j < length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i < length) {
            nums[i] = 0;
            i++;
        }
    }
}
