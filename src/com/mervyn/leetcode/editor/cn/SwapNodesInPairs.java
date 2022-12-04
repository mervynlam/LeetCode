//Given a linked list, swap every two adjacent nodes and return its head. 
//
// You may not modify the values in the list's nodes. Only nodes itself may be c
//hanged. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 674 👎 0


package com.mervyn.leetcode.editor.cn;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        SwapNodesInPairs pairs = new SwapNodesInPairs();
        ListNode n1 = pairs.new ListNode(1, pairs.new ListNode(2, pairs.new ListNode(3, pairs.new ListNode(4))));
        solution.swapPairs(n1);
    }

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
        public ListNode swapPairs(ListNode head) {
            ListNode root = new ListNode(0, head);
            ListNode pre = root;
            ListNode a = head;
            while (a != null && a.next != null) {
                ListNode b = a.next;
                pre.next = b;
                a.next = b.next;
                b.next = a;
                pre = a;
                a = a.next;
            }
            return root.next;
        }
//        public ListNode swapPairs(ListNode head) {
//            ListNode pHead = new ListNode(0, head);
//            boolean headFlag = true;
//            while (pHead.next != null && pHead.next.next != null) {
//                ListNode tmp = pHead.next.next.next;
//                pHead.next.next.next = pHead.next;
//                pHead.next = pHead.next.next;
//                pHead.next.next.next = tmp;
//                if (headFlag) {
//                    head = pHead.next;
//                    headFlag = false;
//                }
//                pHead = pHead.next.next;
//            }
//            return head;
//        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}