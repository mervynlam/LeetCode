//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 159 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
         Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    /**
     * 剑指 Offer 32 - III
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root != null) {
            queue1.add(root);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean reverseFlag = false;
        while(!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            list.add(node.val);
            if (node.left != null) queue2.add(node.left);
            if (node.right != null) queue2.add(node.right);

            if (queue1.isEmpty()) {
                queue1.addAll(queue2);
                queue2.clear();
                List<Integer> tmp = new ArrayList<>();
                if (reverseFlag) {
                    Collections.reverse(list);
                }
                tmp.addAll(list);
                result.add(tmp);
                reverseFlag = !reverseFlag;
                list.clear();
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}