//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 267 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DuiChengDeErChaShuLcof {
    public static void main(String[] args) {
         Solution solution = new DuiChengDeErChaShuLcof().new Solution();
         TreeNode one = new TreeNode(1);
         TreeNode two = new TreeNode(2);
         one.right = two;
//         one.left = two;
         solution.isSymmetric(one);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 剑指 Offer 28
     */
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkMirror(root.left, root.right);
    }
    boolean checkMirror(TreeNode a, TreeNode b) {
        if (a == null && b != null || a != null && b == null) return false;
        if (a == null && b == null) return true;
        if (a.val != b.val) return false;
        return checkMirror(a.right, b.left) && checkMirror(a.left, b.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}