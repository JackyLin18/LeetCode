package com.dynamic;

/**
 * @ClassName IsSubsequence
 * @Author Jacky
 * @Description
 **/
public class IsSubsequence {
    public boolean isSubsequence(String s,String t){
        return true;
    }

    // 双指针解法
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
