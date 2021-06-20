package com.string;

/**
 * @ClassName StrStr
 * @Author Jacky
 * @Description 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 **/
public class StrStr {
    public static void main(String[] args) {
        StrStr o = new StrStr();
        System.out.println(o.strStr("mississippi", "issipi"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int hIndex, nIndex;
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        boolean flag = true;
        for (hIndex = 0; hIndex < hChars.length; hIndex++) {
            int tempIndex = hIndex;
            for (nIndex = 0; nIndex < nChars.length; nIndex++) {
                if (tempIndex >= hChars.length) {
                    flag = false;
                    break;
                }
                if (nChars[nIndex] != hChars[tempIndex++]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return hIndex;
            }
            flag = true;
        }
        return -1;
    }
}
