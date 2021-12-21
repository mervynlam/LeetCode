//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 405 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
         Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
         solution.movingCount(2,2,4);
    }
    
    /**
     * 剑指 Offer 13
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int movingCount(int m, int n, int k) {
        int[][] checked = new int[m][n];
        int result = 1;
        int[][] dir = {
                {-1,0},{0,1},{1,0},{0,-1}
        };

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0,0));
        checked[0][0] = 1;

        while (!queue.isEmpty()) {
            Pos poll = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int x = poll.x+dir[i][0];
                int y = poll.y+dir[i][1];
                if (x < 0 || x >= m || y < 0 || y >= n || checked[x][y] == 1) continue;
                if (calcSum(x, y) <= k) {
                    result++;
                    queue.add(new Pos(x, y));
                    checked[x][y] = 1;
                }
            }
        }
        return result;
    }

    int calcSum(int a, int b) {
        return calcSum(a) + calcSum(b);
    }
    int calcSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}