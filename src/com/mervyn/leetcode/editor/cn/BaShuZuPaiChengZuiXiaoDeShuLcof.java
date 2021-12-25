//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 340 👎 0


package com.mervyn.leetcode.editor.cn;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
         Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
    }
    
    /**
     * 剑指 Offer 45
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        quickSort(nums,0, nums.length-1);
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
    void quickSort(int[] num, int start, int end) {
        if (start >= end) return;
        int base = num[start];
        int a = start;
        int b = end;
        while(a < b) {
            while(a < b && comp(num[b], base) >= 0) b--;
            while(a < b && comp(num[a], base) <= 0) a++;
            if (a<b) swap(num, a, b);
        }
        swap(num, start, a);
        quickSort(num, start, a-1);
        quickSort(num, a+1,end);
    }

    void swap(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }

    int comp(int a, int b) {
        String ab = a+""+b;
        String ba = b+""+a;
        for (int i = 0; i < ab.length(); ++i) {
            if (ab.charAt(i) > ba.charAt(i)) {
                return 1;
            } else if (ab.charAt(i) < ba.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}