//You are given coins of different denominations and a total amount of money amo
//unt. Write a function to compute the fewest number of coins that you need to mak
//e up that amount. If that amount of money cannot be made up by any combination o
//f the coins, return -1. 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: coins = [1], amount = 1
//Output: 1
// 
//
// Example 5: 
//
// 
//Input: coins = [1], amount = 2
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 890 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange {
    //322
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
    }

    /**
     * dp[i] : 要组成i，需要的最少硬币数
     * 对于每个硬币，在dp[i]是都可以选择要或者不要
     * 要则 dp[i-aw]+1
     * 不要则 dp[i]
     * 取较小值即可
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int dp[] = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; ++i) {
                for (int aw : coins) {
                    if (aw > i) continue;
                    dp[i] = Math.min(dp[i], dp[i - aw] + 1);
                }
            }
            return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}