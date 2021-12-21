//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 474 👎 0


package com.mervyn.leetcode.editor.cn;

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
         Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
         solution.exist(new char[][]
                 {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "");
    }
    
    /**
     * 剑指 Offer 12
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] checked;
    int[][] dir = {
            {-1,0},{0,1},{1,0},{0,-1}
    };
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;
        checked = new int[m][n];
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    checked[i][j] = 1;
                    boolean dfs = dfs(board, i + dir[0][0], j + dir[0][1], chars, 1) ||
                            dfs(board, i + dir[1][0], j + dir[1][1], chars, 1) ||
                            dfs(board, i + dir[2][0], j + dir[2][1], chars, 1) ||
                            dfs(board, i + dir[3][0], j + dir[3][1], chars, 1);
                    if (dfs) return true;
                    checked[i][j] = 0;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int x, int y, char[] word, int index) {
        if (index >= word.length) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (checked[x][y] == 1) return false;
        if (board[x][y] == word[index]) {
            checked[x][y] = 1;
            boolean flag = dfs(board, x + dir[0][0], y + dir[0][1], word, index + 1) ||
                            dfs(board, x + dir[1][0], y + dir[1][1], word, index + 1) ||
                            dfs(board, x + dir[2][0], y + dir[2][1], word, index + 1) ||
                            dfs(board, x + dir[3][0], y + dir[3][1], word, index + 1);
            if (flag) return true;
            checked[x][y] = 0;
            return false;
        } else {
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}