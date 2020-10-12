//A message containing letters from A-Z is being encoded to numbers using the fo
//llowing mapping: 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// Given a non-empty string containing only digits, determine the total number o
//f ways to decode it. 
//
// The answer is guaranteed to fit in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: s = "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
//.
// 
//
// Example 3: 
//
// 
//Input: s = "0"
//Output: 0
//Explanation: There is no character that is mapped to a number starting with '0
//'. We cannot ignore a zero when we face it while decoding. So, each '0' should b
//e part of "10" --> 'J' or "20" --> 'T'.
// 
//
// Example 4: 
//
// 
//Input: s = "1"
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only digits and may contain leading zero(s). 
// 
// Related Topics 字符串 动态规划 
// 👍 523 👎 0


package com.mervyn.leetcode.editor.cn;

public class DecodeWays {

    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        solution.numDecodings("2611055971756562");
    }

    /**
     * 分四种情况：
     * 1. 当前位为0：
     *     1.1. 不能和前一位组成10 \ 20，return 0;
     *     1.2. 能和前一位组成10 \ 20， dp[i] = dp[i-2]
     * 2. 当前位不为0：
     *     2.1. 不能和前一位组成11-26的数，dp[i] = dp[i-1]
     *     2.2. 能和前一位组成11-26的数，dp[i] = dp[i-1] + dp[i-2]
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            int[] dp = new int[s.length()+1];
            dp[0] = 1;
            dp[1] = s.charAt(0)=='0'?0:1;
            for (int i = 1; i < s.length(); ++i) {
                int twoDigit = Integer.valueOf(s.substring(i-1,i))*10+Integer.valueOf(s.substring(i, i+1));
                if (twoDigit == 0) return 0;
                if (s.charAt(i) == '0') {
                    if (twoDigit>20) return 0;
                    dp[i+1] = dp[i-1];
                    continue;
                }
                if (twoDigit>10 && twoDigit<=26) {
                    dp[i+1] = dp[i-1]+dp[i];
                } else {
                    dp[i+1] = dp[i];
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}