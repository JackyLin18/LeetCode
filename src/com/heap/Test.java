package com.heap;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Author Jacky
 * @Description
 **/
public class Test {
    public static void main(String[] args) {
        int[] arr = {5,-1};
        KthLargest kthLargest = new KthLargest(3, arr);
//        System.out.println(kthLargest.add(2));
        System.out.println(Arrays.toString(kthLargest.heapArray));
//        System.out.println(kthLargest.add(1));
    }
}
