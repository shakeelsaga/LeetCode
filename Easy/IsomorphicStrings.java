package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) { // Length mismatch check
            return false;
        }
        
        // Create two maps to track mappings between characters
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            // Check if sChar is already mapped, and if mapped to the same tChar
            if (mapS.containsKey(sChar)) {
                if (mapS.get(sChar) != tChar) {
                    return false;
                }
            } else {
                mapS.put(sChar, tChar); // Add mapping from s to t
            }

            // Check if tChar is already mapped, and if mapped to the same sChar
            if (mapT.containsKey(tChar)) {
                if (mapT.get(tChar) != sChar) {
                    return false;
                }
            } else {
                mapT.put(tChar, sChar); // Add mapping from t to s
            }
        }
        
        return true; // Strings are isomorphic
    }
}
