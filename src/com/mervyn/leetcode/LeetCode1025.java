package com.mervyn.leetcode;

import java.util.Scanner;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 *
 * 链接：https://leetcode-cn.com/problems/divisor-game
*/
public class LeetCode1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            boolean ret = divisorGame(N);
            System.out.println(ret);
        }
    }

    /**
     * 取到1输，2赢。
     * 往后所有数循环其所有约数，遇到false则表示对方为true。
     */
    public static boolean divisorGame(int N) {
        if (N == 1) return false;
        boolean dp[] = new boolean[N+1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; ++i) {
            dp[i] = false;
            for (int j = 1; j < i/2; ++j) {
                if (i%j==0 && !dp[i-j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}