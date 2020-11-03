//Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were i
//nserted in order. 
//
// 
// Example 1: 
// Input: nums = [1,3,5,6], target = 5
//Output: 2
// Example 2: 
// Input: nums = [1,3,5,6], target = 2
//Output: 1
// Example 3: 
// Input: nums = [1,3,5,6], target = 7
//Output: 4
// Example 4: 
// Input: nums = [1,3,5,6], target = 0
//Output: 0
// Example 5: 
// Input: nums = [1], target = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums contains distinct values sorted in ascending order. 
// -104 <= target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 724 👎 0


package com.mervyn.leetcode.editor.cn;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        System.out.println(solution.searchInsert(new int[]{1}, 1));
    }

    /**
     * 35
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums[0]>target) return 0;
            if (nums[nums.length-1] < target) return nums.length;
            int left = 0;
            int right = nums.length-1;
            int index;
            while (left < right) {
                index = (left + right) / 2;
                if (nums[index] == target) {
                    return index;
                }
                if (nums[index] < target) {
                    left = index+1;
                } else {
                    right = index;
                }
            }
            if (left == right) return left;
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}