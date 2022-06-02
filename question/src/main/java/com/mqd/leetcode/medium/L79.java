package com.mqd.leetcode.medium;

/**
 * leetcode 79 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class L79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        L79 p = new L79();
        System.out.println(p.exist(board, "SSE"));
    }

    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag = dfs(board, word.toCharArray(), 0, i, j);
                    if (flag) break;
                }
            }
            if (flag) break;
        }
        return flag;
    }

    public boolean dfs(char[][] board, char[] word, int index, int i, int j) {
        if (index >= word.length || i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != word[index]) {
            return false;
        }
        if (word.length - 1 == index && word[word.length - 1] == board[i][j]) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '0';
        boolean res = dfs(board, word, index + 1, i + 1 , j) ||
                dfs(board, word, index + 1, i - 1 , j) ||
                dfs(board, word, index + 1, i , j + 1) ||
                dfs(board, word, index + 1, i , j - 1);
        board[i][j] = temp;
        return res;
    }
}
