package dp;

import java.util.Scanner;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Interview08_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ret = waysToStep(n);
            System.out.println(ret);
        }
    }

    /**
     * 三种情况，
     * 1.上一次在i-1阶，跨1阶到达
     * 2.上一次在i-2阶，跨2阶到达（跨2次1阶同第一种情况）
     * 3.上一次在i-3阶，跨3阶到达，（跨1后2同第二种情况，跨2后1同第一种）
     * 所以总数为上述三种情况和。
     */
    public static int waysToStep(int n) {
        final int MOD = 1000000007;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int a = 1;
        int b = 2;
        int c = 4;
        for (int i = 4; i <= n; ++i) {
            int tmpa = a;
            int tmpb = b;
            int tmpc = c;
            a = b;
            b = c;
            c = ((tmpa + tmpb) % MOD + tmpc) % MOD;
        }
        return c;
    }
}