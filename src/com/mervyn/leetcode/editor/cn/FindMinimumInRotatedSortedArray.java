//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Return the minimum element of this array. 
//
// 
// Example 1: 
// Input: nums = [3,4,5,1,2]
//Output: 1
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2]
//Output: 0
// Example 3: 
// Input: nums = [1]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// All the integers of nums are unique. 
// nums is sorted and rotated at some pivot. 
// 
// Related Topics 数组 二分查找 
// 👍 286 👎 0


package com.mervyn.leetcode.editor.cn;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        solution.findMin(new int[]{1});
    }

    /**
     * 153
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            if (nums[nums.length-1] > nums[0]) return nums[0];
            int l = 0, r = nums.length-1;
            int ans = Integer.MAX_VALUE;
            while (l <= r) {
                int mid = ((r-l)>>1)+l;
                if (nums[mid] >= nums[0]) {
                    l = mid+1;
                } else {
                    r = mid -1;
                }
                ans = Math.min(ans, nums[mid]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}