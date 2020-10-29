//Given the root of a binary tree, return the postorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [3,2,1]
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
//Output: [2,1]
// 
//
// Example 5: 
//
// 
//Input: root = [1,null,2]
//Output: [2,1]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree is in the range [0, 100]. 
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
// 👍 468 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    //145
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> valStack = new Stack<>();
            TreeNode cur = root;
            stack.push(cur);
            while(!stack.empty()) {
                cur = stack.pop();
                valStack.push(cur.val);
                if (cur.left != null)
                    stack.push(cur.left);
                if (cur.right != null)
                    stack.push(cur.right);
            }
            while(!valStack.empty())
                result.add(valStack.pop());
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
//    递归
//    执行耗时:0 ms,击败了100.00% 的Java用户
//    内存消耗:36.5 MB,击败了96.74% 的Java用户
//    class Solution {
//        List<Integer> result = new ArrayList<>();
//        public List<Integer> postorderTraversal(TreeNode root) {
//            dfs(root);
//            return result;
//        }
//
//        private void dfs(TreeNode node) {
//            if (node == null) return;
//            dfs(node.left);
//            dfs(node.right);
//            result.add(node.val);
//        }
//    }
}