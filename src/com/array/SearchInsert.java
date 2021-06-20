package com.array;

/**
 * @ClassName SearchInsert
 * @Author Jacky
 * @Description
 **/
public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert o = new SearchInsert();
        int[] arr = {1,3,5,7,9};
        System.out.println(o.searchInsert(arr, 0));
        System.out.println(o.searchInsert(arr, 1));
        System.out.println(o.searchInsert(arr, 2));
        System.out.println(o.searchInsert(arr, 3));
        System.out.println(o.searchInsert(arr, 4));
        System.out.println(o.searchInsert(arr, 5));
        System.out.println(o.searchInsert(arr, 6));
        System.out.println(o.searchInsert(arr, 7));
        System.out.println(o.searchInsert(arr, 8));
        System.out.println(o.searchInsert(arr, 9));
        System.out.println(o.searchInsert(arr, 10));
//        int[] arr = {1, 3, 5, 7};
//        System.out.println(o.searchInsert(arr, 0));
//        System.out.println(o.searchInsert(arr, 1));
//        System.out.println(o.searchInsert(arr, 2));
//        System.out.println(o.searchInsert(arr, 3));
//        System.out.println(o.searchInsert(arr, 4));
//        System.out.println(o.searchInsert(arr, 5));
//        System.out.println(o.searchInsert(arr, 6));
//        System.out.println(o.searchInsert(arr, 7));
//        System.out.println(o.searchInsert(arr, 8));
    }

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int l = 0;
        int r = length - 1;
        int n = length / 2;
        // {1,3,5,7} 2
        while (n >= 0 && n < length) {
            if (r - l <= 1) {
                if (target <= nums[l]) {
                    return l;
                } else if (nums[r] < target) {
                    return r + 1;
                } else {
                    return r;
                }
            }
            if (nums[n] == target) {
                return n;
            } else if (nums[n] > target) {
                r = n;
            } else {
                l = n;
            }
            n = (r + l) / 2;
        }
        return Math.min(n, length);
    }
}
