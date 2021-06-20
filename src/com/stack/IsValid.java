package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName IsValid
 * @Author Jacky
 * @Description
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 **/
public class IsValid {
    public static void main(String[] args) {
        IsValid o = new IsValid();
        System.out.println(o.isValid("()"));
        System.out.println(o.isValid("([])"));
        System.out.println(o.isValid("{[(])}"));
        System.out.println(o.isValid("{{{()[]}}"));
        System.out.println(o.isValid("[][]({})"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        for (char aChar : chars) {
            if (stack.isEmpty() || stack.peek() != map.get(aChar)) {
                stack.push(aChar);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

