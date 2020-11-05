//Given two integers dividend and divisor, divide two integers without using mul
//tiplication, division, and mod operator. 
//
// Return the quotient after dividing dividend by divisor. 
//
// The integer division should truncate toward zero, which means losing its frac
//tional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2. 
//
// Note: 
//
// 
// Assume we are dealing with an environment that could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume th
//at your function returns 231 − 1 when the division result overflows. 
// 
//
// 
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = truncate(3.33333..) = 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = truncate(-2.33333..) = -2.
// 
//
// Example 3: 
//
// 
//Input: dividend = 0, divisor = 1
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: dividend = 1, divisor = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// -231 <= dividend, divisor <= 231 - 1 
// divisor != 0 
// 
// Related Topics 数学 二分查找 
// 👍 452 👎 0


package com.mervyn.leetcode.editor.cn;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        solution.divide(-20, 3);
    }

    /**
     * 29
     * 除法竖式
     * 1. 除数左移，计数需要移多少位
     * 2. 除数右移：
     *      1. 被除数大于等于除数，答案左移+1；
     *      2. 小于答案左移；
     *    直到移动次数归零。
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            boolean sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
            long dd = dividend < 0 ? -(long)dividend : dividend;
            long ds = divisor < 0 ? -(long)divisor : divisor;
            int count = 0;
            while (ds <= dd) {
                ds <<= 1;
                count++;
            }
            long ans = 0;
            while (count-- > 0) {
                ds >>= 1;
                if (dd >= ds) {
                    ans = (ans << 1) + 1;
                    dd = dd - ds;
                } else {
                    ans <<= 1;
                }
            }
            if (!sign && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return (int) (!sign ? ans : -ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}