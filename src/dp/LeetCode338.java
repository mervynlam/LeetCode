package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class LeetCode338 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] ret = countBits(n);
            System.out.println(Arrays.toString(ret));
        }
    }

    /**
     * 0：0
     * 1：1
     * 偶数：res[i/2]
     * 奇数：res[i-1]+1
     */
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <= num; ++i) {
            if (i == 0 || i == 1) {
                res[i] = i;
                continue;
            }
            if ((i & 1) == 1) {
                res[i] = res[i-1]+1;
            } else {
                res[i] = res[i/2];
            }
        }
        return res;
    }
}