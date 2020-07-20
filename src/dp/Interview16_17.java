package dp;

import java.util.Scanner;

/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 */
public class Interview16_17 {
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
     * 分两种情况：
     * 1. 当前数与前面连着取，max[i-1] + nums[i]
     * 2. 当前数与前面不连着取，nums[i]
     * 取上述两者较大值
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int a = nums[0];
        int max = a;
        for (int i = 1; i < nums.length; ++i) {
            a = Math.max(nums[i], a + nums[i]);
            if (a > max) {
                max = a;
            }
        }
        return max;
    }
}