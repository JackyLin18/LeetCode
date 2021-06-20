package com.dynamic;

/**
 * @ClassName MaxProduct
 * @Author Jacky
 * @Description
 **/
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] f = new int[length];
        computeF(f, nums);
        return f[length - 1];
    }

    public void computeF(int[] f, int[] nums) {
        int length = f.length;
        f[0] = nums[0];
        boolean flag = true;
        for (int i = 1; i < length; i++) {
            int temp = Math.max(nums[i], f[i - 1]);
            if (flag) {
                if (f[i - 1] * nums[i] >= temp) {
                    f[i] = f[i - 1] * nums[i];
                    flag = true;
                } else {
                    f[i] = temp;
                    flag = false;
                }
            } else {
                f[i] = temp;
                flag = true;
            }
        }
    }
}
