//一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩
//师找到最优的预约集合（总预约时间最长），返回总的分钟数。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例 1： 
//
// 输入： [1,2,3,1]
//输出： 4
//解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
// 
//
// 示例 2： 
//
// 输入： [2,7,9,3,1]
//输出： 12
//解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
// 
//
// 示例 3： 
//
// 输入： [2,1,4,5,3,1,1,3]
//输出： 12
//解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
// 
// Related Topics 动态规划 
// 👍 132 👎 0


package com.mervyn.leetcode.editor.cn;

public class TheMasseuseLcci {

    public static void main(String[] args) {
        Solution solution = new TheMasseuseLcci().new Solution();
    }

    /**
     * 每个预约都可以选或者不选
     * 如果选，当前预约为 max[i-2] + nums[i]
     * 如果不选，当前预约为 max[i-1]
     * 则当前最佳为 上述两者最佳
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int massage(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int a = 0;
            int b = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (i == 0) {
                    a = nums[i];
                    continue;
                }
                if (i == 1) {
                    b = Math.max(a, nums[i]);
                    continue;
                }

                int tmp = a;
                a = b;
                b = Math.max(tmp + nums[i], b);
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}