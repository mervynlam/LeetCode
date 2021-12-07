//You are given an m x n integer matrix grid, and three integers row, col, and 
//color. Each value in the grid represents the color of the grid square at that 
//location. 
//
// Two squares belong to the same connected component if they have the same 
//color and are next to each other in any of the 4 directions. 
//
// The border of a connected component is all the squares in the connected 
//component that are either 4-directionally adjacent to a square not in the component, 
//or on the boundary of the grid (the first or last row or column). 
//
// You should color the border of the connected component that contains the 
//square grid[row][col] with color. 
//
// Return the final grid. 
//
// 
// Example 1: 
// Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//Output: [[3,3],[3,2]]
// Example 2: 
// Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//Output: [[1,3,3],[2,3,3]]
// Example 3: 
// Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//Output: [[2,2,2],[2,1,2],[2,2,2]]
// 
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 123 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringABorder {
    public static void main(String[] args) {
         Solution solution = new ColoringABorder().new Solution();
         solution.colorBorder(new int[][]{{1,2,1},{1,2,2},{2,2,1}}, 1, 1, 2);
    }
    
    /**
     * 1034
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dir = new int[][]{
            {-1,0}, {0,1}, {1,0}, {0,-1}
    };
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int org = grid[row][col];
        int m = grid.length;
        int n = grid[0].length;
        int[][] checked = new int[m][n];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(row, col));
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            checked[pos.x][pos.y] = 1;
            boolean needColor = false;
            for(int i = 0; i < dir.length; ++i) {
                int x = pos.x + dir[i][0];
                int y = pos.y + dir[i][1];
                if (x < 0 || y < 0 || x >= m || y >= n) {
                    needColor = true;
                    continue;
                }
                if (org != grid[x][y]) {
                    if (checked[x][y] == 0) {
                        needColor = true;
                    }
                } else {
                    if (checked[x][y] == 0) {
                        queue.add(new Position(x, y));
                    }
                }
            }
            if (needColor) {
                grid[pos.x][pos.y] = color;
            }
        }
        return grid;
    }
    class Position{
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}