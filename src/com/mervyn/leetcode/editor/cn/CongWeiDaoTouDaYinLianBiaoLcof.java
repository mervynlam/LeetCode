//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 212 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
         Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * 剑指 Offer 06
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
    public int[] reversePrint(ListNode head) {
        ListNode now = head;
        Stack<Integer> stack = new Stack<>();
        while(now != null) {
            stack.push(now.val);
            now = now.next;
        }
        if (stack.size() == 0) {
            return new int[]{};
        }
        int[] arr = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()) {
            arr[index++] = stack.pop();
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}