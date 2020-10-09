//给定一个整数数组，找出总和最大的连续数列，并返回总和。 
//
// 示例： 
//
// 输入： [-2,1,-3,4,-1,2,1,-5,4]
//输出： 6
//解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶： 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 47 👎 0


package com.mervyn.leetcode.editor.cn;

public class ContiguousSequenceLcci {

    public static void main(String[] args) {
        Solution solution = new ContiguousSequenceLcci().new Solution();
    }

    /**
     * 分两种情况：
     * 1. 当前数与前面连着取，max[i-1] + nums[i]
     * 2. 当前数与前面不连着取，nums[i]
     * 取上述两者较大值
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length < 1) {
                return 0;
            }
            int a = nums[0];
            int max = a;
            for (int i = 1; i < nums.length; ++i) {
                a = Math.max(nums[i], a + nums[i]);
                if (a > max) {
                    max = a;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}