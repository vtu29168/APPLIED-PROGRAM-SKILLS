import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Identify and mark invalid parentheses
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Found a match, remove from stack
                } else {
                    sb.setCharAt(i, '*'); // Unmatched ')' marked for removal
                }
            }
        }
        
        // Any remaining '(' in the stack are unmatched, mark them for removal
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        
        // Step 2: Build the final string excluding the markers
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '*') {
                result.append(sb.charAt(i));
            }
        }
        
        return result.toString();
    }
}