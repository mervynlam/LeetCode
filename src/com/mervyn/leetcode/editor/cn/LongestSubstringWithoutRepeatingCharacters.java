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

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> charIndex = new HashMap<>();
            int result = 0;
            for (int end = 0, start = 0; end < s.length(); ++end) {
                char endc = s.charAt(end);
                if (charIndex.containsKey(endc)) {
                    start=Math.max(charIndex.get(endc), start);
                }
                charIndex.put(endc, end+1);
                result = Math.max(end - start + 1, result);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
//题解一
//执行耗时:9 ms,击败了48.42% 的Java用户
//内存消耗:38.8 MB,击败了92.10% 的Java用户
//    class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            List<Integer> subStringList = new ArrayList<>();
//            if (s.length() == 0) return 0;
//            int result = 0;
//            for (int i = 0; i < s.length(); ++i) {
//                int c = s.charAt(i);
//                if (subStringList.contains(c)) {
//                    result = Math.max(result, subStringList.size());
//                    int index = subStringList.indexOf(c);
//                    for (int j = index; j >= 0; --j) subStringList.remove(j);
//                    subStringList.add(c);
//                } else {
//                    subStringList.add(c);
//                }
//            }
//            result = Math.max(result, subStringList.size());
//            return result;
//        }
//    }
}