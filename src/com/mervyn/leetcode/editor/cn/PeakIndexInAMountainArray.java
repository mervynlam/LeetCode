//Let's call an array arr a mountain if the following properties hold: 
//
// 
// arr.length >= 3 
// There exists some i with 0 < i < arr.length - 1 such that:
// 
// arr[0] < arr[1] < ... arr[i-1] < arr[i] 
// arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
// 
// 
// 
//
// Given an integer array arr that is guaranteed to be a mountain, return any i 
//such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr
//.length - 1]. 
//
// 
// Example 1: 
// Input: arr = [0,1,0]
//Output: 1
// Example 2: 
// Input: arr = [0,2,1,0]
//Output: 1
// Example 3: 
// Input: arr = [0,10,5,2]
//Output: 1
// Example 4: 
// Input: arr = [3,4,5,1]
//Output: 2
// Example 5: 
// Input: arr = [24,69,100,99,79,78,67,36,26,19]
//Output: 2
// 
// 
// Constraints: 
//
// 
// 3 <= arr.length <= 104 
// 0 <= arr[i] <= 106 
// arr is guaranteed to be a mountain array. 
// 
// Related Topics 二分查找 
// 👍 121 👎 0


package com.mervyn.leetcode.editor.cn;

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        Solution solution = new PeakIndexInAMountainArray().new Solution();
    }

    /**
     * 852
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int l = 1, r = arr.length-1;
            while (l < r) {
                int mid = ((r-l)>>1)+l;
                if (checkMountain(arr, mid) == 0) {
                    return mid;
                }
                if (checkMountain(arr, mid) < 0) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return -1;
        }

        //-1上坡 0顶峰 1下坡
        int checkMountain(int[] arr, int index) {
            if (arr[index] > arr[index-1] && arr[index] > arr[index+1]) return 0;
            if (arr[index] > arr[index-1]) return -1;
            if (arr[index] > arr[index+1]) return 1;
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}