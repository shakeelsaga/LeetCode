package LeetCode.Easy;

public class IsSubsequence {
    
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(); // Get the length of string s
        int m = t.length(); // Get the length of string t
        if (n == 0) return true; // An empty string s is always a subsequence

        // Loop until we reach the end of either string s or t
        while (i < n && j < m) {
            char c1 = s.charAt(i); // Current character from string s
            char c2 = t.charAt(j); // Current character from string t

            if (c1 != c2) {
                j++; // If characters don't match, move to the next character in t
            } else {
                i++; // If characters match, move to the next character in both s and t
                j++;
            }
        }

        return i == n; // Return true if all characters in s have been matched
    }
}
