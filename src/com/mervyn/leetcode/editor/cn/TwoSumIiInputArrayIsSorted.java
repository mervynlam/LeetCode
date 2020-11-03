//Given an array of integers that is already sorted in ascending order, find two
// numbers such that they add up to a specific target number. 
//
// The function twoSum should return indices of the two numbers such that they a
//dd up to the target, where index1 must be less than index2. 
//
// Note: 
//
// 
// Your returned answers (both index1 and index2) are not zero-based. 
// You may assume that each input would have exactly one solution and you may no
//t use the same element twice. 
// 
//
// 
// Example 1: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
// 
//
// Example 2: 
//
// 
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 3 * 104 
// -1000 <= nums[i] <= 1000 
// nums is sorted in increasing order. 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 419 👎 0


package com.mervyn.leetcode.editor.cn;

public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
    }

    /**
     * 167
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length-1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{left + 1, right +1};
                }
                if (sum > target)
                    right--;
                else
                    left++;
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
//    执行耗时:1 ms,击败了96.61% 的Java用户
//    内存消耗:38.5 MB,击败了93.12% 的Java用户
//    class Solution {
//        public int[] twoSum(int[] numbers, int target) {
//            for (int i = 0; i < numbers.length-1; ++i) {
//                int existIndex = binarySearch(target-numbers[i], numbers, i+1);
//                if (existIndex != -1 && i != existIndex) {
//                    return new int[]{i+1, existIndex+1};
//                }
//            }
//            return new int[0];
//        }
//
//        int binarySearch(int num, int[] nums, int left) {
//            int right = nums.length-1;
//            while (left <= right) {
//                int mid = ((right - left)>>1)+left;
//                if (nums[mid] == num) return mid;
//                if (nums[mid] < num) {
//                    left = mid+1;
//                } else {
//                    right = mid-1;
//                }
//            }
//            return -1;
//        }
//    }
}