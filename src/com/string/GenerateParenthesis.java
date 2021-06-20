package com.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenerateParenthesis
 * @Author Jacky
 * @Description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 **/
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis o = new GenerateParenthesis();
        System.out.println(o.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public void generate(List<String> result, StringBuilder cur,
                         int open, int close, int max) {
        if (cur.length() == max * 2) {
            result.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            generate(result, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            generate(result, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
