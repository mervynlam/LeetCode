//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 188 👎 0


package com.mervyn.leetcode.editor.cn;

public class OneAwayLcci {
    public static void main(String[] args) {
         Solution solution = new OneAwayLcci().new Solution();
        System.out.println(solution.oneEditAway("ab", "a"));
        System.out.println(solution.oneEditAway("ab", "b"));
        System.out.println(solution.oneEditAway("ab", "c"));
    }
    
    /**
     * 面试题 01.05
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int cnt = 0;
    public boolean oneEditAway(String first, String second) {
        int fl = first.length();
        int sl = second.length();
        if (Math.abs(fl-sl)>1) return false;
        if (fl <= 1 && sl <= 1 && cnt<1) {
            return true;
        }
        int p1 = 0;
        int p2 = 0;
        while(p1< fl && p2< sl) {
            if (first.charAt(p1) == second.charAt(p2)) {
                p1++;
                p2++;
            } else {
                if (cnt >= 1) {
                    return false;
                } else {
                    cnt++;
                    return oneEditAway(first.substring(p1), second.substring(p2+1))
                            ||oneEditAway(first.substring(p1+1), second.substring(p2))
                            ||oneEditAway(first.substring(p1+1), second.substring(p2+1));
                }
            }
        }
        if ((p1 != fl || p2 != sl) && cnt >= 1) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}