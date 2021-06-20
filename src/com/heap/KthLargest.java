package com.heap;

/**
 * @ClassName KthLargest
 * @Author Jacky
 * @Description
 * 设计一个找到数据流中第 k 大元素的类（class）。
 * 注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 *     KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 *     int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 **/
public class KthLargest {
    int[] heapArray;
    int k;
    int count;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        initHeap(nums);
        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public void initHeap(int[] nums) {
        heapArray = new int[k];
        if(nums.length == 0){
            return;
        }
        if (nums.length < k) {
            System.arraycopy(nums, 0, heapArray,
                    0, nums.length);
            // 不足，以min补足
            int min = nums[0];
            for (int num : nums) {
                min = Math.min(num, min);
            }
            for (int i = nums.length; i < k; i++) {
                heapArray[i] = min;
            }
            count = nums.length;
        } else {
            System.arraycopy(nums, 0, heapArray,
                    0, k);
            count = k;
        }
        createMinHeap(heapArray);
    }

    public void createMinHeap(int[] arr) {
        for (int i = heapArray.length / 2 - 1; i >= 0; i--) {
            adjustMinHeap(arr, i);
        }
    }

    public int add(int val) {
        if (count >= k) {
            if (val >= heapArray[0]) {
                // 弹出顶部，以val代替
                heapArray[0] = val;
                adjustMinHeap(heapArray, 0);
            }
        } else {
            heapArray[0] = val;
            count++;
            adjustMinHeap(heapArray, 0);
        }
        return heapArray[0];
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
