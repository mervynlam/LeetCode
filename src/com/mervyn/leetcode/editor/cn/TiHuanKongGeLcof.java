//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 185 👎 0


package com.mervyn.leetcode.editor.cn;

public class TiHuanKongGeLcof {
    public static void main(String[] args) {
         Solution solution = new TiHuanKongGeLcof().new Solution();
    }
    
    /**
     * 剑指 Offer 05
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] chars = new char[length * 3];
        int size = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = s.charAt(i);
            }
        }
        return new String(chars, 0, size);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}