//Given an array A of strings made only from lowercase letters, return a list of
// all characters that show up in all strings within the list (including duplicate
//s). For example, if a character occurs 3 times in all strings but not 4 times, y
//ou need to include that character three times in the final answer. 
//
// You may return the answer in any order. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: ["bella","label","roller"]
//Output: ["e","l","l"]
// 
//
// 
// Example 2: 
//
// 
//Input: ["cool","lock","cook"]
//Output: ["c","o"]
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] is a lowercase letter 
// 
// 
// Related Topics 数组 哈希表 
// 👍 165 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {

    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        solution.commonChars(new String[]{"bella","label","roller"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] A) {
            List<String> result = new ArrayList<>();
            if (A == null || A.length == 0) return result;
            int[] minCount = new int[26];
            Arrays.fill(minCount, Integer.MAX_VALUE);
            for (int i = 0; i < A.length; ++i) {
                int[] count = new int[26];
                for (int j = 0; j < A[i].length(); ++j)
                    count[A[i].charAt(j) - 'a']++;
                for (int j = 0; j < minCount.length; ++j)
                    minCount[j] = Math.min(minCount[j], count[j]);
            }
            for (int i = 0; i < minCount.length; ++i) {
                for (int j = 0; j < minCount[i]; ++j) {
                    result.add(String.valueOf((char)('a'+i)));
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}