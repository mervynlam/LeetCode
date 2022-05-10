//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 640 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
         Solution solution = new ZhongJianErChaShuLcof().new Solution();
         solution.buildTree(new int[]{6,3,8,5,7,2,9,13,20,11}, new int[]{8,5,3,2,7,6,13,9,11,20});
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 剑指 Offer 07
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
    int preIndex;
    Map<Integer, Integer> inorderIndexMap;
    public Solution() {
        preIndex = 0;
        inorderIndexMap = new HashMap<>();
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        for (int i = 0; i < inorder.length; ++i) inorderIndexMap.put(inorder[i],i);
        return buildTree(preorder, inorder, inorderIndexMap.get(preorder[preIndex]), 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int now, int left, int right) {
        if (now < left || now > right) return null;
        if (left > right) return null;
        if (left == right) return new TreeNode(inorder[left]);
        TreeNode node = new TreeNode(inorder[now]);
        if (++preIndex < preorder.length) {
            Integer nextIndex = inorderIndexMap.get(preorder[preIndex]);
            if (nextIndex < now && nextIndex >= left) {
                node.left = buildTree(preorder, inorder, nextIndex, left, now - 1);
                if (++preIndex < preorder.length)
                    nextIndex = inorderIndexMap.get(preorder[preIndex]);
            }
            if (nextIndex > now && nextIndex <= right)
                node.right = buildTree(preorder, inorder, nextIndex, now+1, right);
            else preIndex--;
        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}