package com.mervyn.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
*/
public class LeetCode3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            System.out.println(lengthOfLongestSubstring(s));
        }
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Integer> charSet = new HashSet<Integer>();
        int result = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i);
            if (charSet.contains(c)) {
                charSet.clear();
                charSet.add(c);
                if (temp > result) {
                    result = temp;
                }
                temp = 1;
            } else {
                charSet.add(c);
                temp++;
            }
        }
        if (temp > result) {
            result = temp;
        }
        return result;
    }
}
