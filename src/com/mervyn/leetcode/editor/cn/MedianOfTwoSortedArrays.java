//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3363 👎 0


package com.mervyn.leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
    }

    /**
     * 4
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0 && nums2.length == 0) return 0;
            int[] merge = new int[nums1.length + nums2.length];
            int index = 0;
            int num1Index = 0;
            int num2Index = 0;
            while (num1Index < nums1.length && num2Index < nums2.length) {
                if (nums1[num1Index] < nums2[num2Index]) {
                    merge[index++] = nums1[num1Index];
                    num1Index++;
                } else {
                    merge[index++] = nums2[num2Index];
                    num2Index++;
                }
            }
            if (num1Index == nums1.length) {
                while (num2Index < nums2.length) {
                    merge[index++] = nums2[num2Index];
                    num2Index++;
                }
            }
            if (num2Index == nums2.length) {
                while(num1Index < nums1.length) {
                    merge[index++] = nums1[num1Index];
                    num1Index++;
                }
            }
            return (merge.length & 1) == 1? merge[merge.length/2] : (merge[(merge.length-1)/2]+merge[merge.length/2])/2.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}