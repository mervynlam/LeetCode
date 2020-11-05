//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// The array may contain duplicates. 
//
// Example 1: 
//
// 
//Input: [1,3,5]
//Output: 1 
//
// Example 2: 
//
// 
//Input: [2,2,2,0,1]
//Output: 0 
//
// Note: 
//
// 
// This is a follow up problem to Find Minimum in Rotated Sorted Array. 
// Would allow duplicates affect the run-time complexity? How and why? 
// 
// Related Topics 数组 二分查找 
// 👍 194 👎 0


package com.mervyn.leetcode.editor.cn;

public class FindMinimumInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArrayIi().new Solution();
        solution.findMin(new int[]{3,3,1,3});
    }

    /**
     * 154
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            if (nums[nums.length-1] > nums[0]) return nums[0];
            int l = 0, r = nums.length-1;
            int ans = nums[0];
            while (l <= r) {
                if (nums[l] == nums[r] && nums[l] == nums[0]) {
                    l++;
                    r--;
                    continue;
                }
                int mid = ((r-l)>>1)+l;
                if (nums[mid] > nums[r]) {
                    l = mid+1;
                } else {
                    r = mid - 1;
                }
                ans = Math.min(ans, nums[mid]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}