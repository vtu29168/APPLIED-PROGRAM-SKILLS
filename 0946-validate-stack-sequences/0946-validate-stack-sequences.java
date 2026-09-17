import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer for the popped array
        
        for (int x : pushed) {
            stack.push(x);
            
            // While stack is not empty and top matches the current popped element
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        
        // If the stack is empty, all elements were successfully popped in order
        return stack.isEmpty();
    }
}