//Given a string s which consists of lowercase or uppercase letters, return the 
//length of the longest palindrome that can be built with those letters. 
//
// Letters are case sensitive, for example, "Aa" is not considered a palindrome 
//here. 
//
// 
// Example 1: 
//
// 
//Input: s = "abccccdd"
//Output: 7
//Explanation:
//One longest palindrome that can be built is "dccaccd", whose length is 7.
// 
//
// Example 2: 
//
// 
//Input: s = "a"
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: s = "bb"
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2000 
// s consists of lowercase and/or uppercase English letters only. 
// 
// Related Topics 贪心 哈希表 字符串 👍 413 👎 0


package com.mervyn.leetcode.editor.cn;

public class LongestPalindrome {
    public static void main(String[] args) {
         Solution solution = new LongestPalindrome().new Solution();
         solution.longestPalindrome("abccccdd");
    }
    
    /**
     * 409
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        boolean hasSingle = false;
        int[] count = new int[26+26];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            int index = cur - 'a'<0?cur-'A'+26:cur-'a';
            count[index]++;
        }
        for (int i = 0; i < count.length; i++) {
            if ((count[i] & 1)==0){
                result += count[i];
            } else {
                if (count[i]>1) result+= count[i]-1;
                hasSingle = true;
            }
        }
        if ((result&1)==0 && hasSingle) result++;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}