package com;

/**
 * @ClassName IsPalindrome
 * @Author Jacky
 * @Description
 **/
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome o = new IsPalindrome();
        System.out.println(o.isPalindrome(-11));
        System.out.println(o.isPalindrome(11));
        System.out.println(o.isPalindrome(121));
        System.out.println(o.isPalindrome(1221));
        System.out.println(o.isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);
        char[] chars = s.toCharArray();
        int length = s.length();
        if(length == 1){
            return true;
        }
        int left = 0;
        int right = length - 1;
        while(left < right){
            if(chars[left++] != chars[right--]){
                return false;
            }
        }
        return true;
    }
}
