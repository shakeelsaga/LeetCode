package LeetCode.Easy;

import java.util.Stack;

public class ValidParanthesis {
    
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false; // No opening bracket to match with
                }
                char top = stack.peek(); //stores the top of the stack in 'top'
                if (s.charAt(i) == ')' && top != '(' ||
                    s.charAt(i) == '}' && top != '{' ||
                    s.charAt(i) == ']' && top != '[') {
                    return false; // Mismatched closing bracket
                } else {
                    stack.pop(); // Pop the matching opening bracket
                }
            }
        }
        return stack.isEmpty(); // Ensure all opening brackets are matched
    }
}
