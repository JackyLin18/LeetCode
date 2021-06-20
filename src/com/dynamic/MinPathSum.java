package com.dynamic;

/**
 * @ClassName MinPathSum
 * @Author Jacky
 * @Description 给定一个包含非负整数的 m x n 网格 grid ，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 **/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        computeF(f, grid, m, n);
        return f[m - 1][n - 1];
    }

    // 状态方程：f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j]
    // i==0||j==0 ==> f[i][j] = grid[i][j]
    public void computeF(int[][] f, int[][] grid,
                         int m, int n) {
        // 初始化第一行和第一列
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }
        // 计算其它
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1])
                        + grid[i][j];
            }
        }
    }
}
