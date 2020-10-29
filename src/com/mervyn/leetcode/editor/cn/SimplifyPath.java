//Given an absolute path for a file (Unix-style), simplify it. Or in other words
//, convert it to the canonical path. 
//
// In a UNIX-style file system, a period . refers to the current directory. Furt
//hermore, a double period .. moves the directory up a level. 
//
// Note that the returned canonical path must always begin with a slash /, and t
//here must be only a single slash / between two directory names. The last directo
//ry name (if it exists) must not end with a trailing /. Also, the canonical path 
//must be the shortest string representing the absolute path. 
//
// 
//
// Example 1: 
//
// 
//Input: "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory nam
//e.
// 
//
// Example 2: 
//
// 
//Input: "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the roo
//t level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced 
//by a single one.
// 
//
// Example 4: 
//
// 
//Input: "/a/./b/../../c/"
//Output: "/c"
// 
//
// Example 5: 
//
// 
//Input: "/a/../../b/../c//.//"
//Output: "/c"
// 
//
// Example 6: 
//
// 
//Input: "/a//b////c/d//././/.."
//Output: "/a/b/c"
// 
// Related Topics 栈 字符串 
// 👍 216 👎 0


package com.mervyn.leetcode.editor.cn;

import java.util.Stack;

public class SimplifyPath {
    //71
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        solution.simplifyPath("/a//b////c/d//././/..");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            String[] pathArr = path.split("/");
            String[] pathStack = new String[pathArr.length];
            int index = 0;
            for (String s : pathArr) {
                if ("".equals(s) || ".".equals(s))
                    continue;
                if ("..".equals(s)) {
                    if (index != 0)
                        index--;
                } else {
                    pathStack[index++] = s;
                }
            }
            if (index == 0) return "/";
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < index; ++i) {
                result.append("/"+pathStack[i]);
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}