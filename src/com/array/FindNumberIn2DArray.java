package com.array;

/**
 * @ClassName FindNumberIn2DArray
 * @Author Jacky
 * @Description
 **/
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        FindNumberIn2DArray o = new FindNumberIn2DArray();
        int[][] arr = {{5},{6}};
        o.findNumberIn2DArray(arr, 6);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int line = matrix.length;
        int row = matrix[0].length;
        int i = 0, j = 0;
        while (i < line) {
            while (j < row && j >= 0 && i<line) {
                System.out.println("i:" + i + "  j:" + j);
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    i++;
                    j--;
                } else {
                    j++;
                }
            }
            i++;
        }
        return false;
    }
}
