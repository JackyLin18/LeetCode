package com.heap;

import java.util.*;

/**
 * @ClassName TopKFrequent
 * @Author Jacky
 * @Description
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 **/
public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        topKFrequent.topKFrequent(arr, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<int[]> queue =
                new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] temp = {entry.getKey(), entry.getValue()};
            if (queue.size() < k) {
                queue.add(temp);
            } else {
                int[] peek = queue.peek();
                assert peek != null;
                if (temp[1] > peek[1]) {
                    queue.poll();
                    queue.offer(temp);
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(queue.poll())[0];
        }
        return result;
    }
}
