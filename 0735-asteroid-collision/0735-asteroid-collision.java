import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a : asteroids) {
            if (a > 0) {
                // Right-moving asteroid, no immediate collision
                stack.push(a);
            } else {
                // Left-moving asteroid, handle collisions
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop(); // The top right-moving asteroid explodes
                }
                
                if (stack.isEmpty() || stack.peek() < 0) {
                    // Current left-moving asteroid survives
                    stack.push(a);
                } else if (stack.peek() == -a) {
                    // Both asteroids are the same size, both explode
                    stack.pop();
                }
                // If stack.peek() > -a, the current asteroid explodes (do nothing)
            }
        }
        
        // Convert stack to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
