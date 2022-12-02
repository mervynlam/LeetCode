//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 878 👎 0


package com.mervyn.leetcode.editor.cn;

public class SpiralMatrixIi {
    public static void main(String[] args) {
         Solution solution = new SpiralMatrixIi().new Solution();
         solution.generateMatrix(3);
    }
    
    /**
     * 59
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int i = 1;
        int x = 0;
        int y = 0;
        int[][] ans = new int[n][n];
        int[][] dir = new int[][]{
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };
        int dirIndex = 0;
        while (i <= n * n) {
            ans[x][y] = i;
            i++;
            int newX = x + dir[dirIndex][0];
            int newY = y + dir[dirIndex][1];
            if (newX < 0 || newX > n-1 || newY < 0 || newY > n-1 || ans[newX][newY] > 0) {
                dirIndex = dirIndex == 3?0:dirIndex+1;
            }
            x = x + dir[dirIndex][0];
            y = y + dir[dirIndex][1];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}