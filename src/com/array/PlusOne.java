package com.array;

import java.util.Arrays;

/**
 * @ClassName PlusOne
 * @Author Jacky
 * @Description
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 **/
public class PlusOne {
    public static void main(String[] args) {
        PlusOne o = new PlusOne();
        int[] digits = {0};
        System.out.println(Arrays.toString(o.plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean flag = true;
        for (int i = 0; i < length; i++) {
            if (digits[i] != 9) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int[] temp = new int[length + 1];
            temp[0] = 0;
            for (int i = 0; i < length; i++) {
                temp[i + 1] = digits[i];
            }
            digits = temp;
        }
        length = digits.length;
        int temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] + temp < 10) {
                digits[i] = digits[i] + temp;
                break;
            } else {
                digits[i] = digits[i] + temp - 10;
            }
        }
        return digits;
    }
}
