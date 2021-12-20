//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 👍 180 👎 0


package com.mervyn.leetcode.editor.cn;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
         Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
         solution.exchange(new int[]{1,3,5});
    }
    
    /**
     * 剑指 Offer 21
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int a = 0;
        int b = nums.length-1;
        while (a < b) {
            while (a < b && (nums[a]&1)==1) a++;
            while (a < b && (nums[b]&1)==0) b--;
            if (a < b) {
                int tmp = nums[a];
                nums[a] = nums[b];
                nums[b] = tmp;
                a++;
                b--;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}