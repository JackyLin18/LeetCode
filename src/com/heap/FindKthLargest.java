package com.heap;

/**
 * @ClassName FindKthLargest
 * @Author Jacky
 * @Description 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 **/
public class FindKthLargest {
    int[] heapArray;
    int k;

    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        this.heapArray = new int[k];
        System.arraycopy(nums, 0, heapArray, 0, k);
        createMinHeap(heapArray);
        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
        }
        return heapArray[0];
    }

    public void createMinHeap(int[] arr) {
        for (int i = heapArray.length / 2 - 1; i >= 0; i--) {
            adjustMinHeap(arr, i);
        }
    }

    public void add(int val) {
        if (val < heapArray[0]) {
            return;
        }
        heapArray[0] = val;
        adjustMinHeap(heapArray, 0);
    }

    public void adjustMinHeap(int[] arr, int i) {
        int minIndex = i;
        int lIndex = 2 * i + 1;
        int rIndex = 2 * i + 2;
        if (lIndex < arr.length && arr[lIndex] < arr[minIndex]) {
            minIndex = lIndex;
        }
        if (rIndex < arr.length && arr[rIndex] < arr[minIndex]) {
            minIndex = rIndex;
        }
        if (i != minIndex) {
            swap(arr, i, minIndex);
            adjustMinHeap(arr, minIndex);
        }
    }

    public void swap(int[] arr, int a, int b) {
        if (a < 0 || b < 0) {
            return;
        }
        if (a >= arr.length || b >= arr.length) {
            return;
        }
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
