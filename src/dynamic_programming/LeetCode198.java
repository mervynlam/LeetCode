package dynamic_programming;

import java.util.Scanner;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
 * 系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode198 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            String[] inputArr = input.split(",");
            int[] nums = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; ++i) {
                nums[i] = Integer.valueOf(inputArr[i]);
            }
            int ret = rob(nums);
            System.out.println(ret);
        }
    }

    /**
     * 偷或不偷
     * 偷，i-2 + nums[i]
     * 不偷 i-1
     * 取两者较大值
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int a = nums[0];
        if (nums.length == 1) {
            return a;
        }
        int b = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return b;
        }
        for (int i = 2; i < nums.length; ++i) {
            int tmp = a;
            a = b;
            b = Math.max(tmp + nums[i], b);
        }
        return b;
    }
}