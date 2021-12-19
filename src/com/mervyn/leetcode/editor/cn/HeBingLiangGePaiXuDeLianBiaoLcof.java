//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 192 👎 0


package com.mervyn.leetcode.editor.cn;

public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
         Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * 剑指 Offer 25
     */
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        ListNode pre = null;
        while (l1 != null && l2 != null) {
            ListNode now;
            if (l1.val < l2.val) {
                now = l1;
                l1 = l1.next;
            } else {
                now = l2;
                l2 = l2.next;
            }
            if (head == null) {
                head = now;
            } else {
                pre.next = now;
            }
            pre = now;
        }
        if (l1 == null) pre.next = l2;
        if (l2 == null) pre.next = l1;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}