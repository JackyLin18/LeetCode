package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LetterCombinations
 * @Author Jacky
 * @Description
 **/
public class LetterCombinations {
    char[][] chars = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static void main(String[] args) {
        LetterCombinations o = new LetterCombinations();
        String digits = "22";
        System.out.println(o.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<StringBuilder> temp = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        int length = digits.length();
        if (length == 0) {
            return result;
        }
        char[] nums = digits.toCharArray();
        for (int i = 0; i < length; i++) {
            addToList(temp, nums[i] - '0');
        }
        for (StringBuilder sb : temp) {
            result.add(sb.toString());
        }
        return result;
    }

    public void addToList(List<StringBuilder> list, int num) {
        int size = list.size();
        if (size == 0) {
            for (int i = 0; i < chars[num - 2].length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(chars[num - 2][i]);
                list.add(sb);
            }
        } else {
            for (StringBuilder stringBuilder : list) {
                for (int j = 0; j < chars[num - 2].length; j++) {
                    StringBuilder temp = new StringBuilder(stringBuilder.toString());
                    if (j == 0) {
                        StringBuilder sb = stringBuilder;
                        sb.append(chars[num - 2][j]);
                    } else {
                        temp.append(chars[num - 2][j]);
                        list.add(temp);
                    }
                }
            }
        }
    }
}
