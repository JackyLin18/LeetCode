package com.string;

/**
 * @ClassName IsSubsequence
 * @Author Jacky
 * @Description
 **/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        return true;
    }
}
