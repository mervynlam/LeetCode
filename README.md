# LeetCode
LeetCode source

使用`leetcode editor`插件

配置：
```
$!velocityTool.camelCaseName(${question.titleSlug})
```
```
${question.content}

package com.mervyn.leetcode.editor.cn;

public class $!velocityTool.camelCaseName(${question.titleSlug}) {

    public static void main(String[] args) {
         Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }
    
    ${question.code}
}
```