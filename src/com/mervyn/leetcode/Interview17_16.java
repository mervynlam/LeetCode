package com.mervyn.leetcode;

import java.util.Scanner;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 */
public class Interview17_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            String[] inputArr = input.split(",");
            int[] nums = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; ++i) {
                nums[i] = Integer.valueOf(inputArr[i]);
            }
            int ret = massage(nums);
            System.out.println(ret);
        }
    }

    /**
     * 每个预约都可以选或者不选
     * 如果选，当前预约为 max[i-2] + nums[i]
     * 如果不选，当前预约为 max[i-1]
     * 则当前最佳为 上述两者最佳
     *
     */
    public static int massage(int[] nums) {
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