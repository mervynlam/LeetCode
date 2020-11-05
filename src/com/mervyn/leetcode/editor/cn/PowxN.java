//Implement pow(x, n), which calculates x raised to the power n (i.e. xn). 
//
// 
// Example 1: 
//
// 
//Input: x = 2.00000, n = 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: x = 2.10000, n = 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
// Constraints: 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 532 👎 0


package com.mervyn.leetcode.editor.cn;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        solution.myPow(34.00515,-3);
    }

    /**
     * 50
     * 快速幂
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            double ans = 1.0;
            double a = x;
            long N = n;
            boolean flag = N < 0;
            if (flag) N = -N;
            while (N > 0) {
                if ((N&1) == 1) {
                    ans *= a;
                }
                a *= a;
                N >>= 1;
            }
            return flag?1.0/ans:ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
//    二分迭代
//    执行耗时:1 ms,击败了97.59% 的Java用户
//    内存消耗:37.7 MB,击败了14.95% 的Java用户
//    class Solution {
//        public double myPow(double x, int n) {
//            long N = n;
//            return N>=0?pow(x, N):1.0/pow(x, -N);
//        }
//
//        public double pow (double x, long n) {
//            if (n == 0) return 1;
//            if (n == 1) return x;
//            if (n == -1) return 1/x;
//            double pow = pow(x, n/2);
//            if ((n & 1) == 1)
//                return pow * pow * x;
//            else return pow * pow;
//        }
//    }
}