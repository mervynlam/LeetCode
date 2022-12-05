//Given two arrays, write a function to compute their intersection. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9] 
// 
//
// Note: 
//
// 
// Each element in the result should appear as many times as it shows in both ar
//rays. 
// The result can be in any order. 
// 
//
// Follow up: 
//
// 
// What if the given array is already sorted? How would you optimize your algori
//thm? 
// What if nums1's size is small compared to nums2's size? Which algorithm is be
//tter? 
// What if elements of nums2 are stored on disk, and the memory is limited such 
//that you cannot load all elements into the memory at once? 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 413 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.*;

public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        solution.intersect(new int[]{4,9,5},new int[]{9,4,9,8,4});
    }

    /**
     * 350
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int[] cnt1 = new int[1001];
            int[] cnt2 = new int[1001];
            for(int i : nums1) cnt1[i]++;
            for(int i : nums2) cnt2[i]++;
            List<Integer> ans = new ArrayList<Integer>();
            for(int i = 0; i < cnt1.length; ++i) {
                int loop = Math.min(cnt1[i], cnt2[i]);
                while (loop-- > 0) {
                    ans.add(i);
                }
            }
            return ans.stream().mapToInt(x -> x).toArray();
        }
//        public int[] intersect(int[] nums1, int[] nums2) {
//            Arrays.sort(nums1);
//            Arrays.sort(nums2);
//            int i = 0, j = 0;
//            List<Integer> list = new ArrayList<>();
//            while (i < nums1.length && j < nums2.length) {
//                if (nums1[i] > nums2[j]) {
//                    j++;
//                } else if (nums1[i] < nums2[j]) {
//                    i++;
//                } else {
//                    list.add(nums1[i]);
//                    i++;
//                    j++;
//                }
//            }
//            int index = 0;
//            int[] ans = new int[list.size()];
//            for (int num : list) {
//                ans[index++] = num;
//            }
//            return ans;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}