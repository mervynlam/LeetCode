//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1274 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
         Solution solution = new SpiralMatrix().new Solution();
    }
    
    /**
     * 54
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        int[][] dir = new int[][]{
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };
        List<Integer> ans = new ArrayList<Integer>();
        int dirIndex = 0;
        for(int i = 0; i < m* n; ++i){
            ans.add(matrix[x][y]);
            matrix[x][y] = 0;
            int newX = x + dir[dirIndex][0];
            int newY = y + dir[dirIndex][1];
            if (newX < 0 || newX > m-1 || newY < 0 || newY > n-1 || matrix[newX][newY] == 0) {
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