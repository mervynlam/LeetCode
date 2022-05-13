//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 你可以删除c字符。
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 贪心 双指针 字符串 👍 491 👎 0


package com.mervyn.leetcode.editor.cn;

public class ValidPalindromeIi {
    public static void main(String[] args) {
         Solution solution = new ValidPalindromeIi().new Solution();
    }
    
    /**
     * 680
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int cnt = 0;
        public boolean validPalindrome(String s) {
            int left = 0;
            int right = s.length()-1;
            if (s.length() == 1 || left >= right) return true;
            while(left < right) {
                if (left<right && s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                }else {
                    if (cnt == 0) {
                        cnt++;
                        return validPalindrome(s.substring(left, right)) || validPalindrome(s.substring(left+1, right+1));
                    }
                    return false;
                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}