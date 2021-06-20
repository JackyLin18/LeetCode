package com;

/**
 * @ClassName IntegerReverse
 * @Author Jacky
 **/
public class IntegerReverse {
    public static void main(String[] args) {
        IntegerReverse o = new IntegerReverse();
        System.out.println(o.reverseByDiv(123));
        System.out.println(o.reverseByDiv(-123));
        System.out.println(o.reverseByDiv(10));
        System.out.println(o.reverseByDiv(-10));
    }

    public int reverseByString(int x) {
        StringBuilder result = new StringBuilder();
        String s = Integer.toString(x);
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (s.contains("-")) {
            result.append("-");
            for (int i = length - 1; i > 0; i--) {
                result.append(chars[i]);
            }
        } else {
            for (int i = length - 1; i >= 0; i--) {
                result.append(chars[i]);
            }
        }
        Long answer = Long.parseLong(result.toString());
        if (answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE) {
            return 0;
        }
        return answer.intValue();
    }

    public int reverseByDiv(int x) {
        long answer = 0;
        while (x >= 10 || x <= -10) {
            int temp = x % 10;
            answer *= 10;
            answer += temp;
            x /= 10;
        }
        answer *= 10;
        answer += x;
        if(answer < Integer.MIN_VALUE||answer>Integer.MAX_VALUE){
            return 0;
        }
        return (int)answer;
    }
}
