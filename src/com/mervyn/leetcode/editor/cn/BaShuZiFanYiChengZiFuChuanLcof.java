//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 338 👎 0


package com.mervyn.leetcode.editor.cn;

public class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
         Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
         solution.translateNum(506);
    }
    
    /**
     * 剑指 Offer 46
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        int count = 0;
        int pre = 0;
        int nm1 = 1;
        int nm2 = 1;
        while(num != 0) {
            int c = num % 10;
            int now;
            if (pre + c*10 < 26 && pre + c*10 >= 10&& count > 0) {
                now = nm1+nm2;
            } else {
                now = nm1;
            }
            nm2 = nm1;
            nm1 = now;
            pre = c;
            num/=10;
            count++;
        }
        return nm1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}