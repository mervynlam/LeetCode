//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 230 👎 0


package com.mervyn.leetcode.editor.cn;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
         Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
         solution.search(new int[]{5,7,7,8,8,10}, 8);
    }
    
    /**
     * 剑指 Offer 53 - I
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int lEdge;
    int rEdge;
    boolean found;
    public int search(int[] nums, int target) {
        lEdge = 0;
        rEdge = nums.length-1;
        found = false;
        findLeftEdge(nums,0,nums.length-1, target);
        findRightEdge(nums,0,nums.length-1, target);
        return found?rEdge-lEdge+1:0;
    }
    void findLeftEdge(int[] nums, int left, int right, int target) {
        if (left > right) {
            return;
        }

        int mid = (left+right)/2;
        if (nums[mid] == target) {
            found = true;
            if (mid > 0 && nums[mid-1] != target) {
                lEdge = mid;
                return;
            }
            findLeftEdge(nums, left, mid-1, target);
        } else if (nums[mid] > target) {
            findLeftEdge(nums, left, mid-1, target);
        } else if (nums[mid] < target) {
            findLeftEdge(nums, mid+1, right, target);
        }
    }
        void findRightEdge(int[] nums, int left, int right, int target) {
            if (left > right) {
                return;
            }

            int mid = (left+right)/2;
            if (nums[mid] == target) {
                found = true;
                if (mid < nums.length-1 && nums[mid+1] != target) {
                    rEdge = mid;
                    return;
                }
                findRightEdge(nums, mid+1, right, target);
            } else if (nums[mid] > target) {
                findRightEdge(nums, left, mid-1, target);
            } else if (nums[mid] < target) {
                findRightEdge(nums, mid+1, right, target);
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

//    void bin(int[] nums, int left, int right, int target) {
//        if (left >= right) {
//            if (left == right && nums[left] == target) count++;
//            return;
//        }
//
//        int min = (left+right) / 2;
//        if (nums[min] == target) {
//            count++;
//            bin(nums, left, min-1, target);
//            bin(nums, min+1, right, target);
//        } else if (nums[min] > target) {
//            bin(nums, left, min-1, target);
//        } else {
//            bin(nums, min+1, right, target);
//        }
//    }
}