//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1472 👎 0


package com.mervyn.leetcode.editor.cn;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
         Solution solution = new MinimumSizeSubarraySum().new Solution();
    }
    
    /**
     * 209
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min = nums.length;
        boolean flag = false;
        int sum = 0;
        for (;right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                flag = true;
                sum -= nums[left++];
            }
        }
        if (!flag) return 0;
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

/*
*
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min = nums.length;
        int sum = nums[0];
        boolean flag = false;
        while (left <= right && right < nums.length) {
            if (sum >= target) {
                int diff = right - left + 1;
                min = Math.min(diff, min);
                sum -= nums[left];
                left++;
                if (left > right) {
                    right = left;
                    sum = 0;
                }
                flag = true;
            } else {
                right++;
                if (right < nums.length)
                    sum += nums[right];
            }
        }
        if (!flag) return 0;
        return min;
    }
* */