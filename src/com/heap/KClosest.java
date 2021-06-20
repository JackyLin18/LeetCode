package com.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName KClosest
 * @Author Jacky
 * @Description
 **/
public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(x->-compare(x)));
        for (int[] point : points) {
            if (queue.size() < k) {
                queue.offer(point);
            } else {
                int[] temp = queue.peek();
                assert temp != null;
                if (compare(point) < compare(temp)) {
                    queue.poll();
                    queue.offer(point);
                }
            }
        }
        int[][] result = new int[k][2];
        return queue.toArray(result);
    }

    public int compare(int[] arr) {
        return arr[0] * arr[0] + arr[1] * arr[1];
    }
}
