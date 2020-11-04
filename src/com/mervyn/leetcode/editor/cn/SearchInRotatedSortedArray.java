//You are given an integer array nums sorted in ascending order, and an integer 
//target. 
//
// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [
//0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// If target is found in the array return its index, otherwise, return -1. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// All values of nums are unique. 
// nums is guranteed to be rotated at some pivot. 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1045 👎 0


package com.mervyn.leetcode.editor.cn;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        solution.search(new int[]{1,3,5}, 1);
    }

    /**
     * 33
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                if (nums[mid] == target) {
                    return mid;
                }
                if (target > nums[0]) {
                    if (nums[mid] < nums[0] || nums[mid] > target) {
                        r = mid - 1;
                        continue;
                    }
                    if (nums[mid] < target) {
                        l = mid + 1;
                        continue;
                    }
                }
                if (target < nums[0]) {
                    if (nums[mid] >= nums[0] || nums[mid] < target) {
                        l = mid + 1;
                        continue;
                    }
                    if (nums[mid] > target) {
                        r = mid - 1;
                        continue;
                    }
                }
                return 0;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}