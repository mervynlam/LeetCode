//Given an array A of integers, return true if and only if it is a valid mountai
//n array. 
//
// Recall that A is a mountain array if and only if: 
//
// 
// A.length >= 3 
// There exists some i with 0 < i < A.length - 1 such that:
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[A.length - 1] 
// 
// 
// 
//
// 
//
//
// 
//
// Example 1: 
//
// 
//Input: [2,1]
//Output: false
// 
//
// 
// Example 2: 
//
// 
//Input: [3,5,5]
//Output: false
// 
//
// 
// Example 3: 
//
// 
//Input: [0,3,2,1]
//Output: true 
// 
// 
//
// 
//
// Note: 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
//
// 
// 
//
// 
// 
// 
// Related Topics 数组 
// 👍 75 👎 0


package com.mervyn.leetcode.editor.cn;

public class ValidMountainArray {
    public static void main(String[] args) {
        Solution solution = new ValidMountainArray().new Solution();
        solution.validMountainArray(new int[]{1,2,3,2,1});
    }

    /**
     * 941
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] A) {
            if (A.length < 3) return false;
            int left = 0;
            int right = A.length - 1;
            while (left < A.length - 1) {
                if (A[left] < A[left + 1]) {
                    left++;
                } else
                    break;
            }
            while (right > 0) {
                if (A[right] < A[right - 1]) {
                    right--;
                } else
                    break;
            }
            return left == right && left != A.length - 1 && right != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
//    执行耗时:3 ms,击败了11.40% 的Java用户
//    内存消耗:39.1 MB,击败了98.35% 的Java用户
//    class Solution {
//        public boolean validMountainArray(int[] A) {
//            if (A.length < 3) return false;
//            int up = 0;
//            int down = 0;
//            for (int i = 1; i < A.length; ++i) {
//                if (A[i] == A[i - 1] || (down > 0 && A[i] > A[i - 1])) {
//                    return false;
//                }
//                up = up + ((A[i] > A[i - 1]) ? 1 : 0);
//                down = down + ((A[i] < A[i - 1]) ? 1 : 0);
//            }
//            return (up > 0 && down > 0) && (up + down == A.length - 1);
//        }
//    }
}