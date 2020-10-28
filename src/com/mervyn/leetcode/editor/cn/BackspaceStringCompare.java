//Given two strings S and T, return if they are equal when both are typed into e
//mpty text editors. # means a backspace character. 
//
// Note that after backspacing an empty text, the text will continue empty. 
//
// 
// Example 1: 
//
// 
//Input: S = "ab#c", T = "ad#c"
//Output: true
//Explanation: Both S and T become "ac".
// 
//
// 
// Example 2: 
//
// 
//Input: S = "ab##", T = "c#d#"
//Output: true
//Explanation: Both S and T become "".
// 
//
// 
// Example 3: 
//
// 
//Input: S = "a##c", T = "#a#c"
//Output: true
//Explanation: Both S and T become "c".
// 
//
// 
// Example 4: 
//
// 
//Input: S = "a#c", T = "b"
//Output: false
//Explanation: S becomes "c" while T becomes "b".
// 
//
// Note: 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S and T only contain lowercase letters and '#' characters. 
// 
//
// Follow up: 
//
// 
// Can you solve it in O(N) time and O(1) space? 
// 
// 
// 
// 
// 
// Related Topics 栈 双指针 
// 👍 174 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
        solution.backspaceCompare("ab#c","ad#c");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            char[] sChar = new char[S.length()];
            char[] tChar = new char[T.length()];
            int sIndex = arrGen(S, sChar);
            int tIndex = arrGen(T, tChar);
            if (sIndex != tIndex) return false;
            for (int i = 0; i < tIndex; ++i) {
                char sc = sChar[i];
                char tc = tChar[i];
                if (sc != tc) return false;
            }
            return true;
        }

        private int arrGen(String str, char[] arr) {
            int index = 0;
            for (int i = 0; i < str.length(); ++i) {
                switch (str.charAt(i)) {
                    case '#':
                        index = index > 0? index-1: index;
                        break;
                    default:
                        arr[index++] = str.charAt(i);
                        break;
                }
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//    class Solution {
//        public boolean backspaceCompare(String S, String T) {
//            Stack<Character> sStack = new Stack<>();
//            Stack<Character> tStack = new Stack<>();
//            stackGen(S, sStack);
//            stackGen(T, tStack);
//            if (sStack.size() != tStack.size()) return false;
//            while (sStack.size() != 0) {
//                char sc = sStack.pop();
//                char tc = tStack.pop();
//                if (tc != sc) return false;
//            }
//            return true;
//        }
//
//        private void stackGen(String str, Stack<Character> stack) {
//            for (int i = 0; i < str.length(); ++i) {
//                switch (str.charAt(i)) {
//                    case '#':
//                        if (stack.size() != 0)
//                            stack.pop();
//                        break;
//                    default:
//                        stack.push(str.charAt(i));
//                        break;
//                }
//            }
//        }
//    }
}