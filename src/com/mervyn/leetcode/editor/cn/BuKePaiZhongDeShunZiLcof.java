//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 183 👎 0


package com.mervyn.leetcode.editor.cn;

public class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
         Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
         solution.isStraight(new int[]{0,0,0,0,0});
    }
    
    /**
     * 剑指 Offer 61
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        int[] poker = new int[14];
        for (int num :nums) {
            poker[num]++;
            if (num != 0 && poker[num] > 1) return false;
        }
        int count = 0;
        for (int i = 1; i<14; ++i) {
            if (count == 5) return true;
            if (poker[i] > 0) {
                count++;
            } else if (poker[i] == 0) {
                if (count > 0 && poker[0] > 0) {
                    count++;
                    poker[0]--;
                } else if (poker[0] == 0) return false;
            }
        }
        if (count + poker[0] == 5) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}