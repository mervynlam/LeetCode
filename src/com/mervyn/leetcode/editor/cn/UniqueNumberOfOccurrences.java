//Given an array of integers arr, write a function that returns true if and only
// if the number of occurrences of each value in the array is unique. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,2,1,1,3]
//Output: true
//Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values
// have the same number of occurrences. 
//
// Example 2: 
//
// 
//Input: arr = [1,2]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
// Related Topics 哈希表 
// 👍 66 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        Solution solution = new UniqueNumberOfOccurrences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            if (arr.length == 0) return true;
            Map<Integer, Integer> timesMap = new HashMap<>();
            for (int num : arr) {
                if (timesMap.get(num) == null) timesMap.put(num, 1);
                else timesMap.put(num, timesMap.get(num)+1);
            }
            Set<Integer> times = new HashSet<>();
            for (int keys: timesMap.keySet()) {
                if (!times.add(timesMap.get(keys))) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}