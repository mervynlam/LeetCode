//给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 输入：[3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 输入：[1,1,1,3,3,2,2,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 
// 👍 275 👎 0

//Two29
package com.mervyn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementIi {

    public static void main(String[] args) {
        Solution solution = new MajorityElementIi().new Solution();
        solution.majorityElement(new int[]{1,1,1,3,3,2,2,2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums.length == 0) return result;
            int cand1 = 0;
            int cand2 = 0;
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (cand1 == nums[i]) {
                    count1++;
                    continue;
                }
                if (cand2 == nums[i]) {
                    count2++;
                    continue;
                }
                if (count1 == 0) {
                    count1 = 1;
                    cand1 = nums[i];
                    continue;
                }
                if (count2 == 0) {
                    count2 = 1;
                    cand2 = nums[i];
                    continue;
                }
                count1--;
                count2--;
            }

            count1 = 0;
            count2 = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (cand1 == nums[i]) count1++;
                else if (cand2 == nums[i]) count2++;
            }
            if (count1 > (nums.length)/3) result.add(cand1);
            if (count2 > (nums.length)/3) result.add(cand2);

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}