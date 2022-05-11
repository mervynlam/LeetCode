//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。 
//
// 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[
//i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。 
// 
//
// 示例 1: 
//
// 
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: g = [1,2], s = [1,2,3]
//输出: 2
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= g.length <= 3 * 10⁴ 
// 0 <= s.length <= 3 * 10⁴ 
// 1 <= g[i], s[j] <= 2³¹ - 1 
// 
// Related Topics 贪心 数组 排序 👍 502 👎 0


package com.mervyn.leetcode.editor.cn;

public class AssignCookies {
    public static void main(String[] args) {
         Solution solution = new AssignCookies().new Solution();
         int[] g = new int[]{1,43,234,6,345,7,345,2,3};
         int[] s = new int[]{1,42,34,56,234,5,634,5,2,5,25};
         solution.findContentChildren(g,s);
    }
    
    /**
     * 455
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        quickSort(g, 0, g.length-1);
        quickSort(s, 0, s.length-1);
        int cnt = 0;
        for (int i = 0, j=0; i < g.length; i++) {
            while(j < s.length && s[j]<g[i]) j++;
            if (j < s.length) {
                cnt++;
                j++;
            }
        }
        return cnt;
    }

    public void quickSort(int[] arr, int left ,int right) {
        if (left >= right) return;
        int base = arr[left];
        int m = left;
        int n = right;
        while (n>m) {
            while (arr[n] >= base && n > m) n--;
            while (arr[m] <= base && n > m) m++;
            if (n > m) swap(arr, m, n);
        }
        swap(arr, left, m);
        quickSort(arr, left, m-1);
        quickSort(arr, m+1, right);
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}