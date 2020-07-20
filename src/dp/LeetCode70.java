package dp;

import java.util.Scanner;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class LeetCode70 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ret = climbStairs(n);
            System.out.println(ret);
        }
    }

    /**
     * 1阶 1种
     * 2阶 2种
     * 第三阶开始，分两种情况：
     * 1. 上一次在前一阶，跨1阶到达
     * 2. 上一次在前面两阶，跨2阶到达，（1阶同第一种情况，排除）
     * 所以每一阶为前两阶和
     */
    public static int climbStairs(int n) {
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
            b = tmp+b;
        }
        return b;
    }
}