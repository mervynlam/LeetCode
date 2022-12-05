//Given two arrays, write a function to compute their intersection. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4] 
// 
//
// Note: 
//
// 
// Each element in the result must be unique. 
// The result can be in any order. 
// 
//
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 250 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        solution.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
    }

    /**
     * 349
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<Integer>();
            Set<Integer> ans = new HashSet<Integer>();
            for(int i : nums1) set.add(i);
            for (int i : nums2) {
                if (set.contains(i)) {
                    ans.add(i);
                }
            }
            int[] ansArr = new int[ans.size()];
            int index = 0;
            for (int i : ans) {
                ansArr[index++] = i;
            }
            return ansArr;
        }
//        public int[] intersection(int[] nums1, int[] nums2) {
//            Set<Integer> set = new HashSet<>();
//            Arrays.sort(nums1);
//            for (int num : nums2) {
//                if (binarySearch(num, nums1))
//                    set.add(num);
//            }
//            int index = 0;
//            int[] ans = new int[set.size()];
//            for (int num : set) {
//                ans[index++] = num;
//            }
//            return ans;
//        }
//
//        boolean binarySearch(int num, int[] nums) {
//            int left = 0;
//            int right = nums.length;
//            while (left < right) {
//                int mid = (left + right) / 2;
//                if (nums[mid] == num) return true;
//                if (nums[mid] > num) {
//                    right = mid;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            return false;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}