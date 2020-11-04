//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// Follow up: Could you write an algorithm with O(log n) runtime complexity? 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 643 👎 0


package com.mervyn.leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        solution.searchRange(new int[]{5,7,7,8,8,10}, 6);
    }

    /**
     * 34,
     * 两组l-r
     * 一组取大于等于target的最小值 - small
     * 一组取小于等于target的最大值 - large
     * small > large 时 不存在target [-1,-1]
     * 否则返回[small, large]
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int l1 = 0, r1 = nums.length - 1;
            int l2 = 0, r2 = nums.length - 1;
            int large = Integer.MIN_VALUE;
            int small = Integer.MAX_VALUE;
            while (l1 <= r1 || l2 <= r2) {
                if (l1 <= r1) {
                    //大于等于target的最小值
                    int mid = ((r1 - l1) >> 1) + l1;
                    if (nums[mid] >= target) {
                        small = Math.min(small, mid);
                        r1 = mid - 1;
                    } else {
                        l1 = mid + 1;
                    }
                }
                if (l2 <= r2) {
                    //小于等于target的最大值
                    int mid = ((r2 - l2) >> 1) + l2;
                    if (nums[mid] <= target) {
                        large = Math.max(large, mid);
                        l2 = mid + 1;
                    } else {
                        r2 = mid - 1;
                    }
                }
            }
            if (small > large)
                return new int[]{-1, -1};
            return new int[]{small, large};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}