package com.mervyn.leetcode;

import java.util.Scanner;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class LeetCode53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            String[] inputArr = input.split(",");
            int[] nums = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; ++i) {
                nums[i] = Integer.valueOf(inputArr[i]);
            }
            int ret = maxSubArray(nums);
            System.out.println(ret);
        }
    }

    /**
     * 每个数字都可以做 选 或 不选 的操作
     * 如果选，则当前子序列和为 max[i-1] + num
     * 如果不选，则当前子序列和为 max[i-1]
     * 那么当前最佳值为以上两者较大值
     */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int tmp = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int calc = tmp + nums[i];
            int num = Math.max(calc, nums[i]);
            tmp = num;
            if (num > ans) {
                ans = num;
            }
        }
        return ans;
    }
}