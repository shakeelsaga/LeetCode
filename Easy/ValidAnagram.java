package LeetCode.Easy;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // If lengths differ, they can't be anagrams
        }

        // Convert both strings to character arrays, sort them, and compare
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray); // Return true if arrays are equal
    }
}
