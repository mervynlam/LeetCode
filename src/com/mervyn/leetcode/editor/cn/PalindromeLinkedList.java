//Given a singly linked list, determine if it is a palindrome. 
//
// Example 1: 
//
// 
//Input: 1->2
//Output: false 
//
// Example 2: 
//
// 
//Input: 1->2->2->1
//Output: true 
//
// Follow up: 
//Could you do it in O(n) time and O(1) space? 
// Related Topics 链表 双指针 
// 👍 748 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
    }

    /**
     * 234
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
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null) {
                slow = slow.next;
            }
            slow = reverse(slow);
            fast = head;
            while (slow != null) {
                if (fast.val != slow.val)
                    return false;
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }
        public ListNode reverse(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode tmp = head.next;
                head.next = newHead;
                newHead = head;
                head = tmp;
            }
            return newHead;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//    栈
//    执行耗时:2 ms,击败了57.97% 的Java用户
//    内存消耗:42.3 MB,击败了27.61% 的Java用户
//    class Solution {
//        public boolean isPalindrome(ListNode head) {
//            ListNode cur = head;
//            Stack<ListNode> stack = new Stack<>();
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.next;
//            }
//            cur = head;
//            while (cur != null) {
//                if (cur.val != stack.pop().val)
//                    return false;
//                cur = cur.next;
//            }
//            return true;
//        }
//    }
}