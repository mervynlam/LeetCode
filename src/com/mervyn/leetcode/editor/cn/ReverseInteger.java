//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Note: 
//Assume we are dealing with an environment that could only store integers withi
//n the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this prob
//lem, assume that your function returns 0 when the reversed integer overflows. 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2250 👎 0


package com.mervyn.leetcode.editor.cn;

public class ReverseInteger {

    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) return 0;
            int ans = 0;
            int navFlag = 1;
            if (x < 0) navFlag = -1;
            x *= navFlag;
            while (x != 0) {
                if (ans > Integer.MAX_VALUE/10) return 0;
                ans = 10*ans+(x%10);
                x /= 10;
            }
            ans *= navFlag;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}