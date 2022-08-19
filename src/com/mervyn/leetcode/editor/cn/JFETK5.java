//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
//
// Related Topics 位运算 数学 字符串 模拟 👍 46 👎 0


package com.mervyn.leetcode.editor.cn;

public class JFETK5 {
    public static void main(String[] args) {
         Solution solution = new JFETK5().new Solution();
         solution.addBinary("0","0");
    }
    
    /**
     * 剑指 Offer II 002
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int step = 0;
        while (i >= 0 || j >= 0) {
            int currA = i >= 0? a.charAt(i--) - '0':0;
            int currB = j >= 0? b.charAt(j--) - '0':0;
            int currSum = currA + currB + step;
            if (currSum >= 2) {
                step = 1;
                sb.append(currSum-2);
            } else {
                step = 0;
                sb.append(currSum);
            }
        }
        if (step > 0) sb.append(1);
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}