package com;

/**
 * @ClassName LongestCommonPrefix
 * @Author Jacky
 * @Description
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix o = new LongestCommonPrefix();
        String[] strs = {"dog","racecar","car"};
        System.out.println(o.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        int minLength = strs[0].length();
        char current;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        for (int i = 0; i < minLength; i++) {
            current = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != current) {
                    return result.toString();
                }
            }
            result.append(current);
        }
        return result.toString();
    }
}
