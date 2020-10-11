//Given a non-empty array nums containing only positive integers, find if the ar
//ray can be partitioned into two subsets such that the sum of elements in both su
//bsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 动态规划 
// 👍 486 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        solution.canPartition(new int[]{2,2,1,1});
    }

    /**
     * dp滚动数组
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums.length <= 1) return false;
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if ((sum & 1) == 1) return false;

            boolean[] dp = new boolean[sum/2+1];
            dp[0] = true;
            for (int i : nums) {
                for (int j = sum/2; j >= i; --j) {
                    dp[j] = dp[j-i] | dp[j];
                }
            }
            return dp[sum/2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//class Solution {
//    public boolean canPartition(int[] nums) {
//        if (nums.length <= 1) return false;
//        Map<Integer, Boolean> numExist = new HashMap<>();
//        int sum = 0;
//        for (int i : nums) {
//            sum += i;
//            Map<Integer, Boolean> tmpMap = new HashMap<>();
//            for (int keys : numExist.keySet()) {
//                tmpMap.put(i+keys, true);
//            }
//            numExist.putAll(tmpMap);
//            numExist.put(i, true);
//        }
//        if ((sum & 1) == 1) return false;
//        return numExist.get(sum/2)==null?false:true;
//    }
//}
//
//runtime:1135 ms
//memory:46.3 MB
}