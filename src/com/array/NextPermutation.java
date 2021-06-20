package com.array;

import java.util.Arrays;

/**
 * @ClassName NextPermutation
 * @Author Jacky
 * @Description
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 **/
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation o = new NextPermutation();
        int[] arr = {1};
        for (int i = 0; i <= 6; i++) {
            System.out.print(Arrays.toString(arr) + "的下一个是：");
            o.nextPermutation(arr);
            System.out.println(Arrays.toString(arr));
        }
//        o.quickSort(arr, 1, arr.length-1);
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i, temp;
        for (i = length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }
        if (i < 1) {
            quickSort(nums, 0, length - 1);
        } else {
            int j = length - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
            quickSort(nums, i, length-1);
        }
    }

    public void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // 获得中轴值
        int pivot = arr[(l + r) / 2];
        int temp;
        // 循环至左右指针碰撞
        while (l < r) {
            // 找到左边第一个大于或等于中轴值的值
            while (arr[l] < pivot) {
                l++;
            }
            // 找到右边第一个小于或等于中轴值的值
            while (arr[r] > pivot) {
                r--;
            }
            // 如果此时l>=r，说明左边的值已全部小于中轴值
            // 右边的值已全部大于中轴值
            if (l >= r) {
                break;
            }
            // 交换，使得小的值到左边，大的值到右边
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 避免死循环
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        // 如果指针此时重叠，l向前走一步，r向后走一步
        if (l == r) {
            l++;
            r--;
        }
        // 递归快排左边一组
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 递归快排右边一组
        if (l < right) {
            quickSort(arr, l, right);
        }
    }
}
