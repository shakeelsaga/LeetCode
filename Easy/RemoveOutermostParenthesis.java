package LeetCode.Easy;

public class RemoveOutermostParenthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (open > 0) {
                    result.append(c); // append if it's not an outermost '('
                }
                open++; // increment open count
            } else {
                open--; // decrement open count
                if (open > 0) {
                    result.append(c); // append if it's not an outermost ')'
                }
            }
        }

        return result.toString();
}
