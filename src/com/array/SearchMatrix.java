package com.array;

/**
 * @ClassName SearchMatrix
 * @Author Jacky
 * @Description
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *     每行中的整数从左到右按升序排列。
 *     每行的第一个整数大于前一行的最后一个整数。
 *
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 **/
public class SearchMatrix {
    public static void main(String[] args) {
        SearchMatrix o = new SearchMatrix();
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
        };
        System.out.println(o.searchMatrix(arr,0));
        System.out.println(o.searchMatrix(arr,3));
        System.out.println(o.searchMatrix(arr,4));
        System.out.println(o.searchMatrix(arr,10));
        System.out.println(o.searchMatrix(arr,13));
        System.out.println(o.searchMatrix(arr,20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int i;
        for (i = 1; i < length; i++) {
            if (matrix[i][0] > target) {
                break;
            }
        }
        int line = i - 1;
        int l = 0;
        int r = matrix[line].length;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (mid >= matrix[line].length) {
                return false;
            }
            if (matrix[line][mid] < target) {
                l = mid + 1;
            } else if (matrix[line][mid] == target) {
                return true;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }


}
