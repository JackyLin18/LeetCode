package com.heap;

import java.util.*;

/**
 * @ClassName KSmallestPairs
 * @Author Jacky
 * @Description
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * 示例 3:
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 **/
public class KSmallestPairs {
    public static void main(String[] args) {
        KSmallestPairs o = new KSmallestPairs();
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        o.kSmallestPairs(nums1,nums2,2);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>
                (Comparator.comparingInt(x -> -(x[0] + x[1])));
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int[] temp = {n1, n2};
                if (!tryToAdd(queue, temp, k)) {
                    break;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            List<Integer> tempList = new ArrayList<>();
            tempList.add(temp[0]);
            tempList.add(temp[1]);
            result.add(tempList);
        }
        return result;
    }

    public boolean tryToAdd(Queue<int[]> queue, int[] arr, int k) {
        if (queue.size() < k) {
            queue.offer(arr);
        } else {
            int[] temp = queue.peek();
            if (arr[0] + arr[1] < temp[0] + temp[1]) {
                queue.poll();
                queue.offer(arr);
            } else {
                return false;
            }
        }
        return true;
    }
}
