package com;

/**
 * @ClassName SingleNumber
 * @Author Jacky
 * @Description
 **/
public class SingleNumber {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }
}
