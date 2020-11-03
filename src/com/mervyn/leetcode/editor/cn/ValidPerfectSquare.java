//Given a positive integer num, write a function which returns True if num is a 
//perfect square else False. 
//
// Follow up: Do not use any built-in library function such as sqrt. 
//
// 
// Example 1: 
// Input: num = 16
//Output: true
// Example 2: 
// Input: num = 14
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 174 👎 0


package com.mervyn.leetcode.editor.cn;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
    }

    /**
     * 367
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 1) return true;
            long l = 0, r = num/2;
            while (l <= r) {
                long mid = ((r-l)>>1)+l;
                long pow = mid*mid;
                if (pow == num) {
                    return true;
                } else if (pow > num) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}