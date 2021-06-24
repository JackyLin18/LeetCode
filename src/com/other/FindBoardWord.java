package com.other;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"。
 * A B C E
 * S F C S
 * A D E E
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class FindBoardWord {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] flag = new boolean[board.length][board[0].length];
                if (findWord(board, j, i, word, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findWord(char[][] board, int x, int y, String word, boolean[][] flag) {
        if (word == null || word.equals("")) {
            return true;
        }
        if (y >= board.length || x >= board[0].length) {
            return false;
        }
        if (y < 0 || x < 0) {
            return false;
        }
        if (flag[y][x]) {
            return false;
        }
        char c = word.charAt(0);
        if (board[y][x] == c) {
            flag[y][x] = true;
            return findWord(board, x + 1, y, word.substring(1), flag) ||
                    findWord(board, x, y + 1, word.substring(1), flag) ||
                    findWord(board, x - 1, y, word.substring(1), flag) ||
                    findWord(board, x, y - 1, word.substring(1), flag) || (flag[y][x] = false);
        } else {
            flag[y][x] = false;
            return false;
        }
    }

//    public static void main(String[] args) {
//        FindBoardWord findBoardWord = new FindBoardWord();
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println(findBoardWord.exist(board, "ABCEFSADEESC"));
//    }
}
