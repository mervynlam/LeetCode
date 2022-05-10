//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2⁻² = 1/2² = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 数学 👍 236 👎 0


package com.mervyn.leetcode.editor.cn;

public class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
         Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
         solution.myPow(34.00515,-3);
    }
    
    /**
     * 剑指 Offer 16
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1/x;
        }
        while (b > 0) {
            if ((b&1)==1) ans *= x;
            x *= x;
            b>>=1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}