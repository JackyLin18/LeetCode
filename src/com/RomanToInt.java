package com;

/**
 * @ClassName RomanToInt
 * @Author Jacky
 * @Description
 **/
public class RomanToInt {
    public static void main(String[] args) {
        RomanToInt o1 = new RomanToInt();
        IntToRoman o2 = new IntToRoman();
        int num = 94;
        String s = o2.intToRoman(num);
        System.out.println(num == o1.romanToInt(s));
    }

    public int romanToInt(String s) {
        int result = 0;
        int flag = 0;
        int lastIndex = s.lastIndexOf('M');
        while (flag <= lastIndex) {
            if (s.charAt(flag) == 'M') {
                result += 1000;
                flag++;
            } else {
                result += 900;
                flag += 2;
            }
        }
        if (s.contains("D")) {
            if (s.contains("CD")) {
                result += 400;
                flag += 2;
            } else {
                result += 500;
                flag++;
            }
        }
        lastIndex = s.lastIndexOf('C');
        while (flag <= lastIndex) {
            if (s.charAt(flag) == 'C') {
                result += 100;
                flag++;
            } else {
                result += 90;
                flag += 2;
            }
        }
        if (s.contains("L")) {
            if (s.contains("XL")) {
                result += 40;
                flag += 2;
            } else {
                result += 50;
                flag++;
            }
        }
        lastIndex = s.lastIndexOf('X');
        while (flag <= lastIndex) {
            if (s.charAt(flag) == 'X') {
                result += 10;
                flag++;
            } else {
                result += 9;
                flag += 2;
            }
        }
        if (s.contains("V")) {
            if (s.contains("IV")) {
                result += 4;
                flag += 2;
            } else {
                result += 5;
                flag++;
            }
        }
        lastIndex = s.lastIndexOf('I');
        while (flag <= lastIndex) {
            if (s.charAt(flag) == 'I') {
                result += 1;
                flag++;
            } else {
                result += 4;
            }
        }
        return result;
    }
}
