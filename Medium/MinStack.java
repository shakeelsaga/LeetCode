package LeetCode.Medium;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;      // Main stack to hold all elements
    private Stack<Integer> minStack;   // Stack to keep track of the minimum values

    // Constructor to initialize both stacks
    public MinStack() {
        stack = new Stack<>(); // Create an instance of the main stack
        minStack = new Stack<>(); // Create an instance of the minStack
    }
    
    // Push a new value onto the stack
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val); // Push the value to the main stack
            minStack.push(val); // Push the value to minStack as the only element is the minimum
        } else {
            // Check if the incoming value is less than or equal to the current minimum
            if (val <= minStack.peek()) {
                stack.push(val); // Push the value to maintain the order
                minStack.push(val); // Push the new minimum onto minStack
            } else {
                stack.push(val); // Push the value to maintain the order
                minStack.push(minStack.peek()); // Re-push the current minimum to keep it at that index
            }
        }
    }
    
    // Remove the top element from the stack
    public void pop() {
        if (stack.isEmpty()) return; // Exit if the stack is empty
        stack.pop(); // Pop the top value from the main stack
        minStack.pop(); // Also pop from minStack to update the minimum
    }
    
    // Return the top element of the stack
    public int top() {
        if (stack.isEmpty()) return -1; // Return -1 if the stack is empty (consider throwing an exception instead)
        return stack.peek(); // Return the top element from the main stack
    }
    
    // Return the minimum element from the stack
    public int getMin() {
        if (minStack.isEmpty()) return -1; // Return -1 if the minStack is empty (consider throwing an exception instead)
        return minStack.peek(); // Return the top element from minStack, which is the minimum
    }
}





