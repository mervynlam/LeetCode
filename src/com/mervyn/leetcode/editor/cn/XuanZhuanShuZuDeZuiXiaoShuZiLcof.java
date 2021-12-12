//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
//
// 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3
//,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 
//输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// Related Topics 数组 二分查找 👍 458 👎 0


package com.mervyn.leetcode.editor.cn;

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
         Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
         solution.minArray(new int[]{3,3,1});
    }
    
    /**
     * 剑指 Offer 11
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;

        while(left < right) {
            int mid = (left + right) / 2;
            if (numbers[left] < numbers[right]) {
                return numbers[left];
            }
            if (left == right-1) {
                break;
            }
            if (numbers[left] == numbers[mid] && numbers[right] == numbers[mid]) {
                return orderFind(numbers, left, right);
            }
            if (numbers[left] <= numbers[mid]) {
                left = mid;
            } else if (numbers[right] >= numbers[mid]) {
                right = mid;
            }
        }
        return numbers[right];
    }

    int orderFind(int[] numbers, int begin, int end) {
        int min = numbers[begin];
        for (int i = begin+1; i < end; ++i) {
            min = numbers[i] < min?numbers[i]:min;
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}