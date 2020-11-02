//Implement int sqrt(int x). 
//
// Compute and return the square root of x, where x is guaranteed to be a non-ne
//gative integer. 
//
// Since the return type is an integer, the decimal digits are truncated and onl
//y the integer part of the result is returned. 
//
// Example 1: 
//
// 
//Input: 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since 
//             the decimal part is truncated, 2 is returned.
// 
// Related Topics 数学 二分查找 
// 👍 531 👎 0


package com.mervyn.leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        solution.mySqrt(8);
    }

    /**
     * 69
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x <= 1) return x;
            long left = 1;
            long right = x / 2 + 1;
            int ans = 0;
            while (left < right) {
                long mid = (left + right) / 2;
                long pow = mid * mid;
                if (pow == x) return (int)mid;
                if (pow < x) {
                    ans = (int)mid;
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}