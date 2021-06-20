package com.string;

/**
 * @ClassName LongestPalindrome
 * @Author Jacky
 * @Description
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 **/
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int beginIndex = 0;
        int endIndex = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int length = s.length();
        if(length<=1){
            return s;
        }
        for (int i = 0; i < length - 1; i++) {
            int nowLength = 0;
            int j = i + 1;
            for (; j < length; j++) {
                if (isPalindrome(chars, i, j)) {
                    nowLength = j - i + 1;
                }
            }
            if (nowLength > maxLength) {
                maxLength = nowLength;
                beginIndex = i;
                endIndex = i + maxLength;
            }
        }
        if(beginIndex==endIndex){
            return s.substring(0,1);
        }
        return s.substring(beginIndex, endIndex);
    }

    public boolean isPalindrome(char[] chars, int i, int j) {
        while (i <= j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }
}
