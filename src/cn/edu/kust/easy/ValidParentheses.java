package cn.edu.kust.easy;

import java.util.LinkedList;

/**
 *
 * 20. Valid Parentheses
 * pass
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char cha : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(cha);
            } else {
                switch (stack.peek()) {
                    case '(':
                        if (cha == ')') {
                            stack.pop();
                        } else {
                            stack.push(cha);
                        }
                        break;
                    case '[':
                        if (cha == ']') {
                            stack.pop();
                        } else {
                            stack.push(cha);
                        }
                        break;
                    case '{':
                        if (cha == '}') {
                            stack.pop();
                        } else {
                            stack.push(cha);
                        }
                        break;
                }
            }
        }

        return stack.isEmpty();
    }
}
