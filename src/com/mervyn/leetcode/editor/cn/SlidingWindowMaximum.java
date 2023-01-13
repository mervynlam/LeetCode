//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2066 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
         Solution solution = new SlidingWindowMaximum().new Solution();
    }
    
    /**
     * 239
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i >= k) pop(deque, nums[i-k]);
            push(deque, nums[i]);
            if (i >= k-1) result[index++] = getMaxValue(deque);
        }
        return result;
    }

    private void pop(Deque<Integer> deque, int val) {
        if (!deque.isEmpty() && deque.peek() == val) deque.pop();
    }

    private void push(Deque<Integer> deque, int val) {
        while (!deque.isEmpty() && deque.peekLast() < val) deque.pollLast();
        deque.addLast(val);
    }

    private int getMaxValue(Deque<Integer> deque) {
        return deque.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}