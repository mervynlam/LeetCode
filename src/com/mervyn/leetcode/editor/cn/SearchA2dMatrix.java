//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//Output: false
// 
//
// Example 3: 
//
// 
//Input: matrix = [], target = 0
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 271 👎 0


package com.mervyn.leetcode.editor.cn;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
    }

    /**
     * 74
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int l = 0, r = matrix.length - 1;
            int row = Integer.MIN_VALUE;
            while (l <= r) {
                //找小于等于target的最大值
                int mid = ((r - l) >> 1) + l;
                if (matrix[mid][0] <= target) {
                    row = Math.max(row, mid);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (row < 0) return false;
            l = 0;
            r = matrix[row].length-1;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                if (matrix[row][mid] == target){
                    return true;
                }
                if (matrix[row][mid] < target){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}