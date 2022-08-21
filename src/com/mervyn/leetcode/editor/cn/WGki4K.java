//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,100]
//输出：100
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 
//
// 
// 注意：本题与主站 137 题相同：https://leetcode-cn.com/problems/single-number-ii/ 
//
// Related Topics 位运算 数组 👍 93 👎 0


package com.mervyn.leetcode.editor.cn;

public class WGki4K {
    public static void main(String[] args) {
         Solution solution = new WGki4K().new Solution();
        solution.singleNumber(new int[]{2,2,3,2});
        solution.singleNumber(new int[]{30000,500,100,30000,100,30000,100});
    }
    
    /**
     * 剑指 Offer II 004
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int[] cnts = new int[32];
        for (int num :
             nums) {
            for (int i = 0; i < 32; i++) {
                cnts[i] += (num >> (31-i)) & 1;
            }
        }
        int result = 0;
        for (int num :
                cnts) {
            result = (result << 1) + num%3;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
*
class Solution {
    public int singleNumber(int[] nums) {
        int[] cnts = new int[32];
        for (int num :
             nums) {
            String bin = d2b(num);
            for (int i = bin.length()-1, j = 0; i >= 0; i--, j++) {
                if (bin.charAt(i) =='1') cnts[j]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnts.length; i++) {
            int a = cnts[i];
            while (a >= 3) {
                a -= 3;
            }
            sb.append(a);
        }
        int result = b2d(sb.reverse().toString());
        System.out.println(result);
        return result;
    }

    private String d2b(int num) {
        return Integer.toBinaryString(num);
    }

    private int b2d(String binary) {
        if (binary.charAt(0) == '0')
            return Integer.parseInt(binary, 2);
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < binary.length(); i++) {
                sb.append((binary.charAt(i) - '0') ^ 1);
            }
            return -(Integer.parseInt(sb.toString(), 2)+1);
        }
    }
}
* */