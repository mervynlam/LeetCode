//给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 
//d 都是 nums 中的元素，且 a != b != c != d 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,4,6]
//输出：8
//解释：存在 8 个满足题意的元组：
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,5,10]
//输出：16
//解释：存在 16 个满足题意的元组：
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁴ 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 数组 哈希表 👍 62 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public static void main(String[] args) {
         Solution solution = new TupleWithSameProduct().new Solution();
    }
    
    /**
     * 1726
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                int mult = nums[i] * nums[j];
                if (map.containsKey(mult)) map.put(mult, map.get(mult) + 1);
                else map.put(mult, 1);
            }
        }
        int result = 0;
        for (int val :
                map.values()) {
            if (val > 2) {
                result += val * (val-2);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}