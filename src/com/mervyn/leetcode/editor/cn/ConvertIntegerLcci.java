//Write a function to determine the number of bits you would need to flip to con
//vert integer A to integer B. 
//
// Example1: 
//
// 
// Input: A = 29 (0b11101), B = 15 (0b01111)
// Output: 2
// 
//
// Example2: 
//
// 
// Input: A = 1，B = 2
// Output: 2
// 
//
// Note: 
//
// 
// -2147483648 <= A, B <= 2147483647 
// 
// Related Topics 位运算 
// 👍 12 👎 0


package com.mervyn.leetcode.editor.cn;

public class ConvertIntegerLcci {
    public static void main(String[] args) {
        Solution solution = new ConvertIntegerLcci().new Solution();
        solution.convertInteger(1,-1);
    }

    /**
     * 面试题 05.06
     * 取A ^ B异或后1的个数。
     * 取1的个数技巧：
     * n &= (n-1)
     * 该表达式消除最低位的1。
     * 例如：
     *   6  110
     * & 5  101
     * --------
     *   4  100
     * & 3  011
     * --------
     *   0  000
     * 所以6有2个1.
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int convertInteger(int A, int B) {
            int diff = A ^ B;
            int ans = 0;
            while (diff != 0) {
                ans++;
                System.out.println(Integer.toBinaryString(diff));
                diff &= (diff-1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}