//Let's call any (contiguous) subarray B (of A) a mountain if the following prop
//erties hold: 
//
// 
// B.length >= 3 
// There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B
//[i] > B[i+1] > ... > B[B.length - 1] 
// 
//
// (Note that B could be any subarray of A, including the entire array A.) 
//
// Given an array A of integers, return the length of the longest mountain. 
//
// Return 0 if there is no mountain. 
//
// Example 1: 
//
// 
//Input: [2,1,4,7,3,2,5]
//Output: 5
//Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
// 
//
// Example 2: 
//
// 
//Input: [2,2,2]
//Output: 0
//Explanation: There is no mountain.
// 
//
// Note: 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
//
// Follow up: 
//
// 
// Can you solve it using only one pass? 
// Can you solve it in O(1) space? 
// 
// Related Topics 双指针 
// 👍 146 👎 0


package com.mervyn.leetcode.editor.cn;

public class LongestMountainInArray {

    public static void main(String[] args) {
        Solution solution = new LongestMountainInArray().new Solution();
        solution.longestMountain(new int[]{875,884,239,731,723,685});
    }

    /**
     * 执行耗时:4 ms,击败了18.80% 的Java用户
     * 内存消耗:39.4 MB,击败了47.15% 的Java用户
    */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestMountain(int[] A) {
            int max = 0;
            int up = 0;
            int down = 0;
            for (int i = 1; i < A.length; ++i) {
                if (A[i] == A[i-1] || down > 0 && A[i] > A[i-1]) up = down = 0;
                up += A[i] > A[i-1]? 1: 0;
                down += A[i] < A[i-1]? 1: 0;
                if (up > 0 && down > 0)max = Math.max(max, up+down+1);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 分以下几种情况：
     * 1. A[i] == A[i-1] : 当前为山脉起始点
     * 2. A[i] < A[i-1] 且 已有最高峰： 山脉长度+1，已出现最高峰
     * 3. A[i] < A[i-1] 且 没有最高峰： 当前位山脉起始点
     * 4. A[i] > A[i-1] 且 已有最高峰： A[i-1] 为山脉起始点
     * 5. A[i] > A[i-1] 且 没有最高峰： 山脉长度+1
     *
     * 执行耗时:3 ms,击败了61.78% 的Java用户
     * 内存消耗:39.3 MB,击败了62.02% 的Java用户
     */
//    class Solution {
//        public int longestMountain(int[] A) {
//            if (A.length <= 2) {
//                return 0;
//            }
//            int max = 0;
//            int cur = 1;
//            boolean flag = false;
//            for (int i = 1; i < A.length; ++i) {
//                if (A[i] < A[i-1] && cur > 1) {
//                    cur++;
//                    max = Math.max(cur, max);
//                    flag = true;
//                } else if (A[i] > A[i-1] && !flag) {
//                    cur++;
//                } else if (A[i] > A[i-1] && flag) {
//                    cur = 2;
//                    flag = false;
//                } else {
//                    cur = 1;
//                    flag = false;
//                }
//            }
//            return max<3?0:max;
//        }
//    }
}