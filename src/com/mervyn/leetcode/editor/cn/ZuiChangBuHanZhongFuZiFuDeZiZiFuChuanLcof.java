//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
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
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 334 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
         Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
         solution.lengthOfLongestSubstring("abcabcbb");
    }
    
    /**
     * 剑指 Offer 48
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> position = new HashMap<>();
        int max = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int now = 0;
            if (position.containsKey(c)) {
                int preIndex = position.get(c);
                now = i-preIndex<=pre?i-preIndex:(pre+1);
            } else {
                now = pre +1;
            }
            pre = now;
            max = now>max?now:max;
            position.put(c, i);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}