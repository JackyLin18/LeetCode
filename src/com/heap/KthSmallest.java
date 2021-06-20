package com.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName KthSmallest
 * @Author Jacky
 * @Description
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 示例 1：
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 *
 * 示例 2：
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 **/
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue =
                new PriorityQueue<>(Comparator.comparingInt((x) -> x));
        int n = matrix.length;
        for (int i = 0; i < n * n; i++) {
            tryToAddToMaxHeap(queue, matrix[i / n][i % n], k);
        }
        return queue.poll();
    }

    public void tryToAddToMaxHeap(Queue<Integer> queue, int val, int k) {
        if (queue.size() <= k) {
            queue.offer(val);
        } else {
            if (queue.peek() > val) {
                queue.offer(val);
            }
        }
    }
}
