package com.mqd.leetcode.hard;

import com.mqd.utils.TimeStatistic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 37. 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 */
public class L37 {

    public static void main(String[] args) {
//        char[][] arr = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };

        char[][] arr = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        };

        Solution p = new Solution();
        TimeStatistic.func(() -> p.solveSudoku(arr));
        System.out.println(Arrays.deepToString(arr));
    }

    static class Solution {
        // 九宫格
        private Set<Character>[][] sudoku;

        // 横
        private Set<Character>[] row;

        // 竖
        private Set<Character>[] col;

        public void solveSudoku(char[][] board) {
            sudoku = new Set[3][3];
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku[i].length; j++) {
                    sudoku[i][j] = new HashSet<>();
                }
            }
            row = new Set[9];
            for (int i = 0; i < row.length; i++) {
                row[i] = new HashSet<>();
            }
            col = new Set[9];
            for (int i = 0; i < col.length; i++) {
                col[i] = new HashSet<>();
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != '.') {
                        sudoku[i / 3][j / 3].add(board[i][j]);
                        row[i].add(board[i][j]);
                        col[j].add(board[i][j]);
                    }
                }
            }
            dfs(board, 0);
        }

        private boolean dfs(char[][] board, int cur) {
            if (cur >= 81) return true;
            if (board[cur / 9][cur % 9] != '.') {
                return dfs(board, cur + 1);
            } else {
                char c = '1';
                while (c <= '9') {
                    boolean f2 = !isExist(cur / 9, cur % 9, c);
                    if (f2){
                        board[cur / 9][cur % 9] = c;
                        add(cur, c);
                        if (dfs(board, cur + 1)) {
                            return true;
                        } else {
                            board[cur / 9][cur % 9] = '.';
                            remove(cur, c);
                        }
                    }
                    c++;
                }
                return false;
            }
        }

        private boolean isExist(int x, int y, char num) {
            return sudoku[x / 3][y / 3].contains(num) || row[x].contains(num) || col[y].contains(num);
        }

        private void add(int cur, char c) {
            sudoku[cur / 9 / 3][cur % 9 / 3].add(c);
            row[cur / 9].add(c);
            col[cur % 9].add(c);
        }

        private void remove(int cur, char c) {
            sudoku[cur / 9 / 3][cur % 9 / 3].remove(c);
            row[cur / 9].remove(c);
            col[cur % 9].remove(c);
        }
    }
}
