//
//Given a list of sorted characters letters containing only lowercase letters, a
//nd given a target letter target, find the smallest element in the list that is l
//arger than the given target.
// 
//Letters also wrap around. For example, if the target is target = 'z' and lette
//rs = ['a', 'b'], the answer is 'a'.
// 
//
// Examples: 
// 
//Input:
//letters = ["c", "f", "j"]
//target = "a"
//Output: "c"
//
//Input:
//letters = ["c", "f", "j"]
//target = "c"
//Output: "f"
//
//Input:
//letters = ["c", "f", "j"]
//target = "d"
//Output: "f"
//
//Input:
//letters = ["c", "f", "j"]
//target = "g"
//Output: "j"
//
//Input:
//letters = ["c", "f", "j"]
//target = "j"
//Output: "c"
//
//Input:
//letters = ["c", "f", "j"]
//target = "k"
//Output: "c"
// 
// 
//
// Note: 
// 
// letters has a length in range [2, 10000]. 
// letters consists of lowercase letters, and contains at least 2 unique letters
//. 
// target is a lowercase letter. 
// 
// Related Topics 二分查找 
// 👍 100 👎 0


package com.mervyn.leetcode.editor.cn;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
    }

    /**
     * 744
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int ans = Integer.MAX_VALUE;
            int l = 0, r = letters.length-1;
            while(l<=r) {
                int mid = ((r-l)>>1)+l;
                if (letters[mid] > target) {
                    ans = Math.min(ans, mid);
                    r = mid-1;
                } else if (letters[mid] <= target) {
                    l = mid+1;
                }
            }
            return ans==Integer.MAX_VALUE?letters[0]:letters[ans];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}