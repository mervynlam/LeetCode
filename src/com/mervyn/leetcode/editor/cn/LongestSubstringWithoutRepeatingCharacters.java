//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4418 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Integer> charSet = new HashSet<Integer>();
            int result = 0;
            int temp = 0;
            for (int i = 0; i < s.length(); ++i) {
                int c = s.charAt(i);
                if (charSet.contains(c)) {
                    charSet.clear();
                    charSet.add(c);
                    if (temp > result) {
                        result = temp;
                    }
                    temp = 1;
                } else {
                    charSet.add(c);
                    temp++;
                }
            }
            if (temp > result) {
                result = temp;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}