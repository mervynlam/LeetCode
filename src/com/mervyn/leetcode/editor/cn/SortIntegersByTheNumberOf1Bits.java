//Given an integer array arr. You have to sort the integers in the array in asce
//nding order by the number of 1's in their binary representation and in case of t
//wo or more integers have the same number of 1's you have to sort them in ascendi
//ng order. 
//
// Return the sorted array. 
//
// 
// Example 1: 
//
// 
//Input: arr = [0,1,2,3,4,5,6,7,8]
//Output: [0,1,2,4,8,3,5,6,7]
//Explantion: [0] is the only integer with 0 bits.
//[1,2,4,8] all have 1 bit.
//[3,5,6] have 2 bits.
//[7] has 3 bits.
//The sorted array by bits is [0,1,2,4,8,3,5,6,7]
// 
//
// Example 2: 
//
// 
//Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
//Output: [1,2,4,8,16,32,64,128,256,512,1024]
//Explantion: All integers have 1 bit in the binary representation, you should j
//ust sort them in ascending order.
// 
//
// Example 3: 
//
// 
//Input: arr = [10000,10000]
//Output: [10000,10000]
// 
//
// Example 4: 
//
// 
//Input: arr = [2,3,5,7,11,13,17,19]
//Output: [2,3,5,17,7,11,13,19]
// 
//
// Example 5: 
//
// 
//Input: arr = [10,100,1000,10000]
//Output: [10,100,10000,1000]
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 500 
// 0 <= arr[i] <= 10^4 
// 
// Related Topics 排序 位运算 
// 👍 43 👎 0


package com.mervyn.leetcode.editor.cn;

public class SortIntegersByTheNumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new SortIntegersByTheNumberOf1Bits().new Solution();
        solution.sortByBits(new int[]{0,1,2,3,4,5,6,7,8});
    }

    /**
     * 1356
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortByBits(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
            return arr;
        }

        void quickSort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }
            int base = arr[l];
            int i = l, j = r;
            while (i < j) {
                while (j > i && compare(base, arr[j]) <= 0)
                    j--;
                while (i < j && compare(base, arr[i]) >= 0)
                    i++;
                if (i < j) {
                    swap(arr, i, j);
                }
            }
            swap(arr, l, i);
            quickSort(arr, l, i-1);
            quickSort(arr, i+1, r);
        }

        void swap(int[] arr, int l, int r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }

        int compare(int a, int b) {
            int countA = countsOfOne(a);
            int countB = countsOfOne(b);
            if (countA > countB) return 1;
            if (countA < countB) return -1;
            if (countA == countB) {
                if (a > b) return 1;
                if (a < b) return -1;
            }
            return 0;
        }

        int countsOfOne(int num) {
            int count = 0;
            while (num > 0) {
                num &= (num - 1);
                count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}