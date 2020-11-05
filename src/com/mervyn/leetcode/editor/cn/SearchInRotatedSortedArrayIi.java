//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]). 
//
// You are given a target value to search. If found in the array return true, ot
//herwise return false. 
//
// Example 1: 
//
// 
//Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false 
//
// Follow up: 
//
// 
// This is a follow up problem to Search in Rotated Sorted Array, where nums may
// contain duplicates. 
// Would this affect the run-time complexity? How and why? 
// 
// Related Topics 数组 二分查找 
// 👍 238 👎 0


package com.mervyn.leetcode.editor.cn;

public class SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
        solution.search(new int[]{1,3,1,1,1}, 3);
    }

    /**
     * 81
     * 相较33,需要做边界处理
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {
            if (nums.length == 0) return false;
            if (target == nums[0] || target == nums[nums.length-1]) {
                return true;
            }
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                if (nums[l] == nums[0]) {
                    l++;
                    continue;
                }
                if (nums[r] == nums[nums.length-1]) {
                    r--;
                    continue;
                }
                int mid = ((r - l) >> 1) + l;
                if (target == nums[mid]) return true;
                if (target > nums[0]) {
                    if (nums[mid] < nums[0] || nums[mid] > target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else if (target < nums[0]) {
                    if (nums[mid] > nums[0] || nums[mid] < target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}