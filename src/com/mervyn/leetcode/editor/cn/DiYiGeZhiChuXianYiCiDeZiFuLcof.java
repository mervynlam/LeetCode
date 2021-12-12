//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 159 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
         Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }
    
    /**
     * 剑指 Offer 50
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> charNums = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (charNums.containsKey(c)) {
                charNums.put(c, charNums.get(c)+1);
            } else {
                charNums.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (charNums.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}