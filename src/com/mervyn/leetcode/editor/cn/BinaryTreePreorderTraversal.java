//Given the root of a binary tree, return the preorder traversal of its nodes' v
//alues. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [1,2]
// 
//
// Example 5: 
//
// 
//Input: root = [1,null,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//
// Follow up: 
//
// Recursive solution is trivial, could you do it iteratively? 
//
// 
// Related Topics 栈 树 
// 👍 436 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curNode = root;
            while (curNode != null || !stack.empty()) {
                while(curNode != null) {
                    result.add(curNode.val);
                    stack.push(curNode);
                    curNode = curNode.left;
                }

                curNode = stack.pop();
                curNode = curNode.right;
            }
            return result;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//    class Solution {
//
//        List<Integer> result = new ArrayList<>();
//
//        public List<Integer> preorderTraversal(TreeNode root) {
//            dfs(root);
//            return result;
//        }
//
//        private void dfs(TreeNode node) {
//            if (node == null) return;
//            result.add(node.val);
//            dfs(node.left);
//            dfs(node.right);
//        }
//    }
}