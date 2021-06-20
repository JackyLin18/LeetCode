package com;

import java.util.HashSet;

/**
 * @ClassName IsValidSudoku
 * @Author Jacky
 * @Description
 **/
public class IsValidSudoku {
    public static void main(String[] args) {
        IsValidSudoku o = new IsValidSudoku();

    }

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] line = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    int index = board[i][j] - '0' - 1;
                    row[i][index]++;
                    row[index][j]++;
                    int x = (i / 3) + index / 3;
                    int y = (j / 3) + index / 3;
                    box[x][y]++;
                    if (row[i][index] > 1 || line[index][j] > 1 || box[x][y] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
