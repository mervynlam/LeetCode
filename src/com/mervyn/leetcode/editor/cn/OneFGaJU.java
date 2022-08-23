//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 
//不重复 的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
//
// Related Topics 数组 双指针 排序 👍 78 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.*;

public class OneFGaJU {
    public static void main(String[] args) {
         Solution solution = new OneFGaJU().new Solution();
         solution.threeSum(new int[]{-2,0,0,2,2});
    }
    
    /**
     * 剑指 Offer II 007
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3) return new ArrayList<>();

        int i = 0;
        while (i < nums.length-2) {
            int left = i+1;
            int right = nums.length-1;
            int target = -nums[i];
            while(left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    result.add(res);
                    while (left < right && nums[left+1] == nums[left]) left++;
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
            while (i < nums.length && nums[i] == -target) i++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}