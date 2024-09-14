//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2237 👎 0


package com.mervyn.leetcode.editor.cn;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
         Solution solution = new ReverseNodesInKGroup().new Solution();
         solution.reverseKGroup(
                 new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))),
                 2
         );
    }
    
    /**
     * 25
     */
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode end = dummy;
        while(end.next != null) {
            int count = 0;
            for (count = 0; count < k && end.next != null; ++count) {
                end = end.next;
            }
            if (count < k) {
                //不够了
                break;
            } else {
                //找到了一组
                ListNode next = end.next;
                ListNode start = pre.next;
                reverse(null, pre.next, k);
                ListNode tmp = end;
                for (int i = 0; i < k; ++i) {
                    System.out.print(tmp.val+"->");
                    tmp = tmp.next;
                }
                pre.next = end;
                pre = start;
                pre.next = next;
                end = pre;
            }
        }
        return dummy.next;
    }

    ListNode reverse(ListNode pre, ListNode cur, int num) {
        ListNode tmp = cur.next;
        cur.next = pre;
        if (num == 1) return cur;
        return reverse(cur, tmp,num-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}