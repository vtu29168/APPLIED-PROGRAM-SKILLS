import java.util.Stack;

class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        // Stack stores int arrays where:
        // stack.peek()[0] = price
        // stack.peek()[1] = span
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // Combine spans of previous days that have a price less than or equal to current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        // Push the current price and its calculated span onto the stack
        stack.push(new int[] {price, span});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */