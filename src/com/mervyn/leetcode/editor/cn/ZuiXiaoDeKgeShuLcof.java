//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 337 👎 0


package com.mervyn.leetcode.editor.cn;

public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
         Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
         solution.getLeastNumbers(new int[]{3,2,1},2);
    }
    
    /**
     * 剑指 Offer 40
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length-1, k);
        int[] result = new int[k];
        for(int i = 0; i < k; ++i) {
            result[i] = arr[i];
        }
        return result;
    }
    void quickSort(int[] arr, int begin, int end, int k) {
        if (begin>=end) return;
        int base = arr[begin];
        int a = begin;
        int b = end;
        while(a < b) {
            while(a < b && arr[b] >= base) b--;
            while(a < b && arr[a] <= base) a++;
            if (a < b) {
                swap(arr, a, b);
            }
        }
        swap(arr, begin, a);
        if (a > k) quickSort(arr, begin, a-1, k);
        if (a < k) quickSort(arr, a+1, end, k);
    }
    void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}