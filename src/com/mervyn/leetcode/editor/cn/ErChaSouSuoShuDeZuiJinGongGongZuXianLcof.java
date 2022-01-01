//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-
//a-binary-search-tree/ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 192 👎 0


package com.mervyn.leetcode.editor.cn;

public class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof {
    public static void main(String[] args) {
         Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();
         TreeNode node6 = new TreeNode(6);
         TreeNode node2 = new TreeNode(2);
         TreeNode node0 = new TreeNode(0);
         TreeNode node4 = new TreeNode(4);
         TreeNode node3 = new TreeNode(3);
         TreeNode node5 = new TreeNode(5);
         TreeNode node8 = new TreeNode(8);
         TreeNode node7 = new TreeNode(7);
         TreeNode node9 = new TreeNode(9);
         node6.left = node2;
         node2.left = node0;
         node2.right = node4;
         node4.left = node3;
         node4.right = node5;
         node6.right = node8;
         node8.left = node7;
         node8.right = node9;
         solution.lowestCommonAncestor(node6, node2, node8);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 剑指 Offer 68 - I
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
    TreeNode smallNode;
    TreeNode largeNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val > q.val) {
            smallNode = q;
            largeNode = p;
        } else {
            smallNode = p;
            largeNode = q;
        }
        return findNode(root);
    }
    TreeNode findNode(TreeNode node) {
        if (node.val > largeNode.val)
            return findNode(node.left);
        if (node.val < smallNode.val)
            return findNode(node.right);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}