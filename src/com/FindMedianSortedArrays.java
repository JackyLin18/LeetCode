package com;

import java.util.Arrays;

/**
 * @ClassName FindMedianSortedArrays
 * @Author Jacky
 * @Description
 **/
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays o = new FindMedianSortedArrays();
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(o.findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = mergeArray(nums1, nums2);
        int length = result.length;
        if (length % 2 == 0) {
            int i1 = result[length / 2];
            int i2 = result[length / 2 - 1];
            return (i1 + i2) / 2.0;
        } else {
            return result[length / 2];
        }
    }

    public int[] mergeArray(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length3 = length1 + length2;
        int[] result = new int[length3];
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < length3; i++) {
            if (temp1 >= length1) {
                result[i] = nums2[temp2++];
                continue;
            }
            if (temp2 >= length2) {
                result[i] = nums1[temp1++];
                continue;
            }
            result[i] = nums1[temp1] < nums2[temp2] ?
                    nums1[temp1++] : nums2[temp2++];
        }
        return result;
    }
}
