package com.mervyn.leetcode;

import java.util.Scanner;

/**
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 */
public class LeetCode746 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            String[] inputArr = input.split(",");
            int[] cost = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; ++i) {
                cost[i] = Integer.valueOf(inputArr[i]);
            }
            int ret = minCostClimbingStairs(cost);
            System.out.println(ret);
        }
    }

    /**
     * 循环t序列，匹配s.charAt(i)。匹配上i+1。继续往后匹配
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int a = cost[0];
        int b = cost[1];
        for (int i = 2; i < cost.length; ++i) {
            int tmp = a;
            a = b;
            b = Math.min(tmp, b) + cost[i];
        }
        return Math.min(a, b);
    }
}