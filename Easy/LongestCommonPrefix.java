package LeetCode.Easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) { // Handle edge case
            return "";
        }
    
        String prefix = strs[0]; // Assume first string as the initial prefix
        
        for (int i = 1; i < strs.length; i++) { // Loop through other strings
            while (strs[i].indexOf(prefix) != 0) { // Check if current string starts with the prefix
                prefix = prefix.substring(0, prefix.length() - 1); // Shorten the prefix
                if (prefix.isEmpty()) { // If no common prefix, return empty string
                    return "";
                }
            }
        }
        
        return prefix; // Return the longest common prefix
    }
}
