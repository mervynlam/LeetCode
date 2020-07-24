package dynamic_programming;

import java.util.Scanner;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 */
public class LeetCode303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
            String input = sc.next();
            String[] inputArr = input.split(",");
            int[] nums = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; ++i) {
                nums[i] = Integer.valueOf(inputArr[i]);
            }
            while(sc.hasNext()) {
                int ret = new NumArray(nums).sumRange(sc.nextInt(), sc.nextInt());
                System.out.println(ret);
            }
//        }
    }
}

class NumArray {

    int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        for (int i = 0; i < nums.length; ++i) {
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}