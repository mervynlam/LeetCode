//给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 ma
//t[r][c] 的和： 
//
// 
// i - K <= r <= i + K, j - K <= c <= j + K 
// (r, c) 在矩阵内。 
// 
//
// 
//
// 示例 1： 
//
// 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
//输出：[[12,21,16],[27,45,33],[24,39,28]]
// 
//
// 示例 2： 
//
// 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
//输出：[[45,45,45],[45,45,45],[45,45,45]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n, K <= 100 
// 1 <= mat[i][j] <= 100 
// 
// Related Topics 动态规划 
// 👍 56 👎 0


package com.mervyn.leetcode.editor.cn;

public class MatrixBlockSum {

    public static void main(String[] args) {
        Solution solution = new MatrixBlockSum().new Solution();
    }

    /**
     * 求矩阵和：[0,0] - [i,j]的和
     * ans[i][j] = sum[i+K][j+K] - sum[i-K-1][j+K] - sum[i+K][j-K-1] + sum[i-K-1][j-K-1]
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int K) {
            int len1 = mat.length;
            int len2 = mat[0].length;
            int[][] sum = new int[len1 + 1][len2 + 1];
            int[][] answer = new int[len1][len2];

            for (int i = 0; i < len1; ++i) {
                for (int j = 0; j < len2; ++j) {
                    sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + mat[i][j];
                }
            }

            for (int i = 0; i < len1; ++i) {
                for (int j = 0; j < len2; ++j) {
                    int x1 = Math.max(0, i - K);
                    int x2 = Math.min(len1, i + K + 1);
                    int y1 = Math.max(0, j - K);
                    int y2 = Math.min(len2, j + K + 1);
                    answer[i][j] = sum[x2][y2] - sum[x1][y2] - sum[x2][y1] + sum[x1][y1];
                }
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}