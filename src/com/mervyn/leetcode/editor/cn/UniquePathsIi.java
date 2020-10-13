//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// Now consider if some obstacles are added to the grids. How many unique paths 
//would there be? 
//
// 
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid. 
//
// Note: m and n will be at most 100. 
//
// Example 1: 
//
// 
//Input:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//Output: 2
//Explanation:
//There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
// 
// Related Topics 数组 动态规划 
// 👍 424 👎 0


package com.mervyn.leetcode.editor.cn;

public class UniquePathsIi {

    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
    }

    /**
     * 如果当前位置有障碍dp[i][j] = 0;
     * 其他dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m+1][n+1];
            dp[1][1] = 1-obstacleGrid[0][0];
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (i == 1 && j == 1) continue;
                    if (obstacleGrid[i-1][j-1] == 1) dp[i][j] = 0;
                    else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}