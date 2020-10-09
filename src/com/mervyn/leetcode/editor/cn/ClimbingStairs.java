//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1270 👎 0


package com.mervyn.leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }

    /**
     * 1阶 1种
     * 2阶 2种
     * 第三阶开始，分两种情况：
     * 1. 上一次在前一阶，跨1阶到达
     * 2. 上一次在前面两阶，跨2阶到达，（1阶同第一种情况，排除）
     * 所以每一阶为前两阶和
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }

            int a = 1;
            int b = 2;
            for (int i = 3; i <= n; ++i) {
                int tmp = a;
                a = b;
                b = tmp + b;
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}