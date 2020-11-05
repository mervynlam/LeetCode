//A peak element is an element that is greater than its neighbors. 
//
// Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and
// return its index. 
//
// The array may contain multiple peaks, in that case return the index to any on
//e of the peaks is fine. 
//
// You may imagine that nums[-1] = nums[n] = -∞. 
//
// Example 1: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index num
//ber 2. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,1,3,5,6,4]
//Output: 1 or 5 
//Explanation: Your function can return either index number 1 where the peak ele
//ment is 2, 
//             or index number 5 where the peak element is 6.
// 
//
// Follow up: Your solution should be in logarithmic complexity. 
// Related Topics 数组 二分查找 
// 👍 325 👎 0


package com.mervyn.leetcode.editor.cn;

public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
        solution.findPeakElement(new int[] {2,1,2});
    }

    /**
     * 162
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            if (nums.length == 1) return 0;
            int l = 0, r = nums.length-1;
            while (l <= r) {
                int mid = ((r-l)>>1)+l;
                int flag = checkMountain(nums, mid);
                if (flag == 0) {
                    return mid;
                }
                if (flag < 0) {
                    l = mid + 1;
                } else {
                    r = mid-1;
                }
            }
            return -1;
        }

        //-1上坡 0顶峰 1下坡
        int checkMountain(int[] arr, int index) {
            if (index == 0) {
                if (arr[index] > arr[index + 1]) return 0;
                else return -1;
            }
            if (index == arr.length-1) {
                if (arr[index] > arr[index - 1]) return 0;
                else return 1;
            }
            if (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) return 0;
            if (arr[index] > arr[index - 1]) return -1;
            if (arr[index] > arr[index + 1]) return 1;
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}