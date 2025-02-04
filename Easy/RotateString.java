package LeetCode.Easy;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false; // If lengths differ, they can't be rotations
        }
        
        // Check if goal is a substring of s + s
        return (s + s).contains(goal);
    }
}
