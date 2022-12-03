//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// 
//MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= index, val <= 1000 
// 请不要使用内置的 LinkedList 库。 
// get, addAtHead, addAtTail, addAtIndex 和 deleteAtIndex 的操作次数不超过 2000。 
// 
//
// Related Topics 设计 链表 👍 697 👎 0


package com.mervyn.leetcode.editor.cn;

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new DesignLinkedList().new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
        System.out.println(myLinkedList.get(5));
        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);
    }
    
    /**
     * 707 这题写的跟屎一样
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {

        class ListNode{
            int val;
            ListNode next;
            public ListNode() {};
            public ListNode(int val){
                this.val = val;
            }
            public ListNode(int val, ListNode node){
                this.val = val;
                this.next = node;
            }
        }

        ListNode head;
        int len;

        public MyLinkedList() {
            this.len = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            if (index < 0 || index >= len) return -1;
            ListNode pre = head;
            for (int i = 0; i <= index; ++i) {
                pre = pre.next;
            }
            return pre.val;
        }

        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            newNode.next = head.next;
            head.next = newNode;
            len++;
        }

        public void addAtTail(int val) {
            ListNode newNode = new ListNode(val);
            ListNode pre = head;
            while (pre.next != null) pre = pre.next;
            pre.next = newNode;
            len++;
        }

        public void addAtIndex(int index, int val) {
            if (index == len) {
                this.addAtTail(val);
            } else if (index <= 0) {
                this.addAtHead(val);
            } else if (index < len) {
                ListNode pre = head;
                for (int i = 0; i < index; ++i) {
                    pre = pre.next;
                }
                ListNode newNode = new ListNode(val);
                newNode.next = pre.next;
                pre.next = newNode;
                len++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < len)  {
                ListNode pre = head;
                for (int i = 0; i < index; ++i) {
                    pre = pre.next;
                }
                pre.next = pre.next.next;
                len--;
            }
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}