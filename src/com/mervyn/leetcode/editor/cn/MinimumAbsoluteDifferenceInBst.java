//Given a binary search tree with non-negative values, find the minimum absolute
// difference between values of any two nodes. 
//
// Example: 
//
// 
//Input:
//
//   1
//    \
//     3
//    /
//   2
//
//Output:
//1
//
//Explanation:
//The minimum absolute difference is 1, which is the difference between 2 and 1 
//(or between 2 and 3).
// 
//
// 
//
// Note: 
//
// 
// There are at least two nodes in this BST. 
// This question is the same as 783: https://leetcode.com/problems/minimum-dista
//nce-between-bst-nodes/ 
// 
// Related Topics 树 
// 👍 144 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumAbsoluteDifferenceInBst {

    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
    }

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
        int ans = Integer.MAX_VALUE;
        int before = -1;
        public void dfs(TreeNode node) {
            if (node.left != null){
                dfs(node.left);
            }
            if (before >= 0)
                ans = Math.min(ans, node.val - before);
            before = node.val;
            if (node.right != null){
                dfs(node.right);
            }
        }
        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//    class Solution {
//        List<Integer> list = new ArrayList<>();
//        public void dfs(TreeNode node) {
//            if (node.left != null){
//                dfs(node.left);
//            }
//            list.add(node.val);
//            if (node.right != null){
//                dfs(node.right);
//            }
//        }
//        public int getMinimumDifference(TreeNode root) {
//            dfs(root);
//            int ans = Integer.MAX_VALUE;
//            for (int i = 0; i < list.size()-1; ++i) {
//                ans = Math.min(ans, list.get(i+1)-list.get(i));
//            }
//            return ans;
//        }
//    }
}