//Given the root of a binary tree, return the inorder traversal of its nodes' va
//lues. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,3,2]
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
// Related Topics 栈 树 哈希表 
// 👍 759 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    //94
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            TreeNode cur = root;
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (cur != null || !stack.isEmpty()) {
                if (cur == null) {
                    cur = stack.pop();
                    result.add(cur.val);
                    cur = cur.right;
                } else {
                    stack.push(cur);
                    cur = cur.left;
                }
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
//    递归
//    执行耗时:0 ms,击败了100.00% 的Java用户
//    内存消耗:36.8 MB,击败了84.35% 的Java用户
//    class Solution {
//        List<Integer> result = new ArrayList<>();
//        public List<Integer> inorderTraversal(TreeNode root) {
//            dfs(root);
//            return result;
//        }
//
//        private void dfs(TreeNode node) {
//            if (node == null) return;
//            dfs(node.left);
//            result.add(node.val);
//            dfs(node.right);
//        }
//    }

    //List<Integer> result = new ArrayList<>();
    //            Stack<TreeNode> stack = new Stack<>();
    //            Stack<Integer> valStack = new Stack<>();
    //            TreeNode cur = root;
    //            while (cur != null || !stack.empty()) {
    //                while(cur != null) {
    //                    stack.push(cur);
    //                    valStack.push(cur.val);
    //                    cur = cur.left;
    //                }
    //
    //                result.add(valStack.pop());
    //
    //                cur = stack.pop().right;
    //            }
    //            while (!valStack.empty()) {
    //                result.add(valStack.pop());
    //            }
    //            return result;
}