//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// Related Topics 数组 双指针 二分查找 👍 143 👎 0


package com.mervyn.leetcode.editor.cn;

public class HeWeiSdeLiangGeShuZiLcof {
    public static void main(String[] args) {
         Solution solution = new HeWeiSdeLiangGeShuZiLcof().new Solution();
    }
    
    /**
     * 剑指 Offer 57
     * 先二分找到小于target的最大值index
     * 然后a=0，index
     * 相加大于target,index--
     * 小于，a++
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int index = findMaxLessThan(nums, 0, nums.length - 1, target);
        if (index <= 0) {
            return new int[]{};
        }
        int a = 0;
        while(a < index) {
            int sum = nums[a] + nums[index];
            if (sum == target) {
                return new int[]{nums[a], nums[index]};
            } else if (sum < target) {
                a++;
            } else {
                index--;
            }
        }
        return new int[]{};
    }
    int findMaxLessThan(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] >= target) {
            if (mid == 0) return -1;
            if (nums[mid-1] < target) return mid-1;
            return findMaxLessThan(nums, left, mid-1, target);
        }
        else {
            if (mid == nums.length-1) return mid;
            if (nums[mid+1] >= target) return mid;
            return findMaxLessThan(nums, mid+1, right, target);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}