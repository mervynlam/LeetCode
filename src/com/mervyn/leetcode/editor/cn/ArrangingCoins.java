//You have a total of n coins that you want to form in a staircase shape, where 
//every k-th row must have exactly k coins. 
// 
// Given n, find the total number of full staircase rows that can be formed. 
//
// n is a non-negative integer and fits within the range of a 32-bit signed inte
//ger. 
//
// Example 1:
// 
//n = 5
//
//The coins can form the following rows:
//¤
//¤ ¤
//¤ ¤
//
//Because the 3rd row is incomplete, we return 2.
// 
// 
//
// Example 2:
// 
//n = 8
//
//The coins can form the following rows:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//Because the 4th row is incomplete, we return 3.
// 
// Related Topics 数学 二分查找 
// 👍 82 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new ArrangingCoins().new Solution();
    }

    /**
     * 441
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            int ans = Integer.MIN_VALUE;
            long l = 0, r = n;
            while (l <= r) {
                long mid = ((r-l)>>1)+l;
                long sum = (mid+1)*mid/2;
                if (sum == n) {
                    return (int)mid;
                }
                if (sum > n) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                    ans = Math.max(ans, (int)mid);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//    执行耗时:12 ms,击败了12.06% 的Java用户
//    内存消耗:35.8 MB,击败了84.35% 的Java用户
//    class Solution {
//        public int arrangeCoins(int n) {
//            if (n == 0) return 0;
//            if (n == 1 || n == 2) return 1;
//            if (n == 3) return 2;
//            long sum = 0;
//            for (int i = 1; i < n/2; ++i) {
//                sum += i;
//                if (sum > n) {
//                    return i - 1;
//                }
//            }
//            return -1;
//        }
//    }
}