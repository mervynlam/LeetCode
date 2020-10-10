//Given a string s consists of upper/lower-case alphabets and empty space charac
//ters ' ', return the length of last word (last word means the last appearing wor
//d if we loop from left to right) in the string. 
//
// If the last word does not exist, return 0. 
//
// Note: A word is defined as a maximal substring consisting of non-space charac
//ters only. 
//
// Example: 
//
// 
//Input: "Hello World"
//Output: 5
// 
//
// 
// Related Topics 字符串 
// 👍 246 👎 0

//Five8
package com.mervyn.leetcode.editor.cn;

public class LengthOfLastWord {

    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
        solution.lengthOfLastWord("");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            boolean flag = false;
            int count = 0;
            for (int i = s.length()-1; i>=0; i--) {
                if (flag && s.charAt(i) == ' ') {
                    break;
                }
                if (s.charAt(i) != ' ') {
                    flag = true;
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}