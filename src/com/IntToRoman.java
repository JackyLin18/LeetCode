package com;

/**
 * @ClassName IntToRoman
 * @Author Jacky
 * @Description
 **/
public class IntToRoman {
    public static void main(String[] args) {
        IntToRoman o = new IntToRoman();
        int num = 60;
        System.out.println(o.intToRoman(num));
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int temp = num / 1000;
        num = num % 1000;
        appendRoman(result, temp, 1000);
        temp = num / 100;
        num = num % 100;
        appendRoman(result, temp, 100);
        temp = num / 10;
        num = num % 10;
        appendRoman(result, temp, 10);
        appendRoman(result, num, 1);
        return result.toString();
    }

    private void appendRoman(StringBuilder sb, int num, int flag) {
        if (flag == 1000) {
            for (int i = 0; i < num; i++) {
                sb.append("M");
            }
            return;
        }
        if (num < 4) {
            if (flag == 100) {
                for (int i = 0; i < num; i++) {
                    sb.append("C");
                }
            } else if (flag == 10) {
                for (int i = 0; i < num; i++) {
                    sb.append("X");
                }
            } else if (flag == 1) {
                for (int i = 0; i < num; i++) {
                    sb.append("I");
                }
            }
        }
        if (num == 4) {
            if (flag == 100) {
                sb.append("CD");
            } else if (flag == 10) {
                sb.append("XL");
            } else if (flag == 1) {
                sb.append("IV");
            }
        }
        if (num >= 5 && num < 9) {
            if (flag == 100) {
                sb.append("D");
                for (int i = 0; i < num - 5; i++) {
                    sb.append("C");
                }
            } else if (flag == 10) {
                sb.append("L");
                for (int i = 0; i < num - 5; i++) {
                    sb.append("X");
                }
            } else if (flag == 1) {
                sb.append("V");
                for (int i = 0; i < num - 5; i++) {
                    sb.append("I");
                }
            }
        }
        if (num == 9) {
            if (flag == 100) {
                sb.append("CM");
            } else if (flag == 10) {
                sb.append("XC");
            } else if (flag == 1) {
                sb.append("IX");
            }
        }
    }
}
