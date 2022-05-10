//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 405 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
         Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
         solution.verifyPostorder(new int[]{3,10,6,9,2});
    }
    
    /**
     * 剑指 Offer 33
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) return true;
        int base = postorder[postorder.length-1];
        int mid = -1;
        for (int i = 0; i < postorder.length-1; ++i) {
            if (postorder[i]>=base && mid < 0) {
                mid = i;
            }
            if (mid >= 0 && postorder[i] < base) {
                return false;
            }
        }
        if (mid == -1) mid = postorder.length-1;
        boolean left = false;
        boolean right = false;
        left = verifyPostorder(Arrays.copyOfRange(postorder, 0, mid));
        right = verifyPostorder(Arrays.copyOfRange(postorder, mid, postorder.length-1));
        return left && right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}