//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 1811 👎 0


package com.mervyn.leetcode.editor.cn;

public class MoveZeroes {
    public static void main(String[] args) {
         Solution solution = new MoveZeroes().new Solution();
    }
    
    /**
     * 283
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int left = 0;
        int right = left+1;
        while (left < right && right < nums.length) {
            while (left < nums.length && nums[left] != 0) left++;
            if (left < nums.length - 1) right = left+1;
            while (right < nums.length && nums[right] == 0) right++;
            if (left < right && right < nums.length) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}