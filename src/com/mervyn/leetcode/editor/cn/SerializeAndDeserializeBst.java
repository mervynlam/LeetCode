//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 320 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBst {
    public static void main(String[] args) {
        Codec ser = new SerializeAndDeserializeBst().new Codec();
        TreeNode root = getNode(3);
        TreeNode node1 = root.left = getNode(1);
        TreeNode node4 = root.right = getNode(4);
        TreeNode node2 = node1.right = getNode(2);
        String tree = ser.serialize(root);
        System.out.println(tree);
        TreeNode ans = ser.deserialize(tree);
        System.out.println(ans);
    }

    private static TreeNode getNode(int val) {
        return new SerializeAndDeserializeBst().new TreeNode(val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * 449
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        List<String> valList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        valList.add(root.val+"");
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                valList.add(node.left.val+"");
            } else {
                valList.add("null");
            }
            if (node.right != null) {
                queue.add(node.right);
                valList.add(node.right.val+"");
            } else {
                valList.add("null");
            }
        }
        return String.join(",",valList);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] split = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(split[index++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            for (int i = 0;i < 2; ++i) {
                if (index >= split.length) break;
                String val = split[index++];
                if (!"null".equals(val)) {
                    Integer valInt = Integer.valueOf(val);
                    if (i == 0) {
                        node.left = new TreeNode(valInt);
                        queue.add(node.left);
                    } else {
                        node.right = new TreeNode(valInt);
                        queue.add(node.right);
                    }
                }
            }
            if (index >= split.length) break;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}