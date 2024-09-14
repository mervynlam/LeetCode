//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 944 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

public class SortAnArray {
    public static void main(String[] args) {
         Solution solution = new SortAnArray().new Solution();
         solution.sortArray(new int[]{5,2,3,1});
    }
    
    /**
     * 912
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    private final Random RANDOM = new Random();
    void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int base = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] > base) j--;
            while (i < j && nums[i] < base) i++;
            if (i < j) swap(nums, i, j);
        }
        if (i == j) {
            swap(nums, left, i);
        }
        quickSort(nums,left, i - 1);
        quickSort(nums, i+1, right);
    }

    void swap (int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}