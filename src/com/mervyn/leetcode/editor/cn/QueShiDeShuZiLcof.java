//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 位运算 数组 哈希表 数学 二分查找 👍 191 👎 0


package com.mervyn.leetcode.editor.cn;

public class QueShiDeShuZiLcof {
    public static void main(String[] args) {
         Solution solution = new QueShiDeShuZiLcof().new Solution();
    }
    
    /**
     * 剑指 Offer 53 - II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result;
    public int missingNumber(int[] nums) {
        result = nums.length;
        bs(nums, 0, nums.length-1);
        return result;
    }

    void bs(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        if (mid == nums[mid]) {
            bs(nums, mid+1, right);
        } else {
            result = mid;
            bs(nums, left, mid-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}