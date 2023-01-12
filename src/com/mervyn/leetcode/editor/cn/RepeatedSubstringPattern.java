//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 852 👎 0


package com.mervyn.leetcode.editor.cn;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
         Solution solution = new RepeatedSubstringPattern().new Solution();
    }
    
    /**
     * 459
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int len = s.length();
            if (len < 2) return false;
            int[] next = new int[len];
            getNext(next, s.toCharArray());
            int max = next[len-1];
            int subLen = len - max;
            return subLen!=len && len%subLen == 0;
        }
        private void getNext(int[] next, char[] s) {
            int j = 0;
            next[0] = 0;
            for (int i = 1; i < s.length; ++i){
                while (j > 0 && s[i] != s[j]) j = next[j-1];
                if (s[i] == s[j]) j++;
                next[i] = j;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}