package com.dynamic;

/**
 * @ClassName NumDecodings
 * @Author Jacky
 * @Description
 **/
public class NumDecodings {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            if(s.charAt(0)=='0'){
                return  0;
            }
            return 1;
        }
        if (s.charAt(0) > '2') {
            return numDecodings(s.substring(1));
        } else {
            if (s.charAt(1) > '6') {
                return numDecodings(s.substring(1));
            } else {
                if (s.length() == 2) {
                    return 2;
                } else {
                    return numDecodings(s.substring(1)) +
                            numDecodings(s.substring(2));
                }
            }
        }
    }
}
