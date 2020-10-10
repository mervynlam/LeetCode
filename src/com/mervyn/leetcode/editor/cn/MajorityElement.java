//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 757 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int c = nums[0];
            int count = 1;
            for (int i = 1; i< nums.length; ++i) {
                if (count == 0) {
                    count = 1;
                    c = nums[i];
                    continue;
                }
                if (c == nums[i]) count++;
                else count--;
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//    class Solution {
//        public int majorityElement(int[] nums) {
//            Arrays.sort(nums);
//            return nums[nums.length / 2];
//        }
//    }
}