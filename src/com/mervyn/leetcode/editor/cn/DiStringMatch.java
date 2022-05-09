//A permutation perm of n + 1 integers of all the integers in the range [0, n] 
//can be represented as a string s of length n where: 
//
// 
// s[i] == 'I' if perm[i] < perm[i + 1], and 
// s[i] == 'D' if perm[i] > perm[i + 1]. 
// 
//
// Given a string s, reconstruct the permutation perm and return it. If there 
//are multiple valid permutations perm, return any of them. 
//
// 
// Example 1: 
// Input: s = "IDID"
//Output: [0,4,1,3,2]
// Example 2: 
// Input: s = "III"
//Output: [0,1,2,3]
// Example 3: 
// Input: s = "DDI"
//Output: [3,2,0,1]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either 'I' or 'D'. 
// 
// Related Topics 贪心 数组 数学 双指针 字符串 👍 340 👎 0


package com.mervyn.leetcode.editor.cn;

public class DiStringMatch {
    public static void main(String[] args) {
         Solution solution = new DiStringMatch().new Solution();
    }
    
    /**
     * 942
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length()+1];
        int head = 0;
        int tail = s.length();
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i) == 'I'? head++: tail--;
        }
        result[s.length()] = head;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}