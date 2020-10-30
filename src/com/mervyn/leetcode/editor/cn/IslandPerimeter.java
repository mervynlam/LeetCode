//You are given row x col grid representing a map where grid[i][j] = 1 represent
//s land and grid[i][j] = 0 represents water. 
//
// Grid cells are connected horizontally/vertically (not diagonally). The grid i
//s completely surrounded by water, and there is exactly one island (i.e., one or 
//more connected land cells). 
//
// The island doesn't have "lakes", meaning the water inside isn't connected to 
//the water around the island. One cell is a square with side length 1. The grid i
//s rectangular, width and height don't exceed 100. Determine the perimeter of the
// island. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//Output: 16
//Explanation: The perimeter is the 16 yellow stripes in the image above.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1]]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,0]]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// row == grid.length 
// col == grid[i].length 
// 1 <= row, col <= 100 
// grid[i][j] is 0 or 1. 
// 
// Related Topics 哈希表 
// 👍 275 👎 0


package com.mervyn.leetcode.editor.cn;

public class IslandPerimeter {
    public static void main(String[] args) {
        Solution solution = new IslandPerimeter().new Solution();
    }

    /**
     * 463
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int islandPerimeter(int[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] == 0) continue;
                    //边缘
                    if (i - 1 < 0) ans++;
                    if (i + 1 == grid.length) ans++;
                    if (j - 1 < 0) ans++;
                    if (j + 1 == grid[i].length) ans++;
                    //中间
                    if (i - 1 >= 0 && grid[i - 1][j] == 0) ans++;
                    if (i + 1 < grid.length && grid[i + 1][j] == 0) ans++;
                    if (j - 1 >= 0 && grid[i][j - 1] == 0) ans++;
                    if (j + 1 < grid[i].length && grid[i][j + 1] == 0) ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}