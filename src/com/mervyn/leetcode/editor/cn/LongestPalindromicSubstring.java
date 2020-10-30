//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// 
// Related Topics 字符串 动态规划 
// 👍 2851 👎 0


package com.mervyn.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("abcdcba");
    }

    /**
     * 5
     * dp方法，第二层循环的范围很重要
     * 不能大于i
     * 画图啊dp!!
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() <= 1) return s;
            boolean[][] dp = new boolean[s.length()][s.length()];
            int max = 1;
            int beginIndex = 0;
            for (int i = 0; i < s.length(); ++i) {
                dp[i][i] = true;
                for (int j = 0; j < i; ++j) {
                    if (i == j+1)
                        dp[j][i] =  s.charAt(j) == s.charAt(i);
                    else
                        dp[j][i] =  dp[j+1][i-1] && s.charAt(j) == s.charAt(i);

                    if (dp[j][i] && i-j+1>max) {
                        max = i-j+1;
                        beginIndex = j;
                    }
                }
            }
            return s.substring(beginIndex, beginIndex+max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//    执行耗时:45 ms,击败了65.75% 的Java用户
//    内存消耗:38.5 MB,击败了71.06% 的Java用户
//    class Solution {
//        public String longestPalindrome(String s) {
//            if (s.length() <= 1) return s;
//            String ans = s.substring(0, 1);
//            int max = 1;
//            for (int i = 1; i < s.length(); ++i) {
//                //回文长度奇数
//                int j = 1;
//                int len = 1;
//                while (i - j >= 0 && i + j < s.length()) {
//                    if (s.charAt(i-j) == s.charAt(i+j)){
//                        len+=2;
//                    }
//                    else {
//                        if (len > max){
//                            max = len;
//                            ans = s.substring(i-j+1, i+j);
//                        }
//                        break;
//                    }
//                    j++;
//                }
//                if (len > max){
//                    max = len;
//                    ans = s.substring(i-j+1, i+j);
//                }
//                //回文长度偶数
//                j = 1;
//                len = 0;
//                while (i - j >= 0 && i + j - 1 < s.length()) {
//                    if (s.charAt(i-j) == s.charAt(i+j-1)){
//                        len+=2;
//                    }
//                    else {
//                        if (len > max){
//                            max = len;
//                            ans = s.substring(i-j+1, i+j-1);
//                        }
//                        break;
//                    }
//                    j++;
//                }
//                if (len > max){
//                    max = len;
//                    ans = s.substring(i-j+1, i+j-1);
//                }
//            }
//            return ans;
//        }
//    }
}