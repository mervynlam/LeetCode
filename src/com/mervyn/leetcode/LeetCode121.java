package com.mervyn.leetcode;

import java.util.Scanner;

/**
 *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
public class LeetCode121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            String[] inputArr = input.split(",");
            int[] prices = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; ++i) {
                prices[i] = Integer.valueOf(inputArr[i]);
            }
            int ret = maxProfit(prices);
            System.out.println(ret);
        }
    }

    /**
     *
     */
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }
            int benifit = prices[i] - min;
            if (benifit > max)
                max = benifit;
        }
        return max;
    }
}