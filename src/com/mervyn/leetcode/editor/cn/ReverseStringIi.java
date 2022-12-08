//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 392 👎 0


package com.mervyn.leetcode.editor.cn;

public class ReverseStringIi {
    public static void main(String[] args) {
         Solution solution = new ReverseStringIi().new Solution();
         solution.reverseStr("a", 3);
    }
    
    /**
     * 541
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        int left = 0;
        int right = Math.min(s.length(), k) -1;
        int tmp = right+1;
        char[] ansArr = new char[s.length()];
        while (left <= right && left < s.length()) {
            while (left <= right) {
                ansArr[left] = s.charAt(right);
                ansArr[right] = s.charAt(left);
                left++;
                right--;
            }
            int end = Math.min(s.length(), tmp+k);
            for (int i = tmp; i < end; ++i) {
                ansArr[i] = s.charAt(i);
            }
            left = end;
            right = Math.min(s.length(), end+k) -1;
            tmp = right+1;
        }
        return new String(ansArr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}