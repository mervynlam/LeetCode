//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2505 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

    /**
     * 每个数字都可以做 选 或 不选 的操作
     * 如果选，则当前子序列和为 max[i-1] + num
     * 如果不选，则当前子序列和为 max[i-1]
     * 那么当前最佳值为以上两者较大值
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int ans = nums[0];
            int tmp = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                int calc = tmp + nums[i];
                int num = Math.max(calc, nums[i]);
                tmp = num;
                if (num > ans) {
                    ans = num;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}