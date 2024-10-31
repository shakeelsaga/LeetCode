package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int subLength = 0;  // Initialize to 0, as the minimum valid substring length is 0
        int low = 0;
        int high = 0;

        Set<Character> vessel = new HashSet<>();

        while (high < s.length()) {
            if (!vessel.contains(s.charAt(high))) {
                vessel.add(s.charAt(high));
                high++;
                // Update the longest substring length after adding a new unique character
                subLength = Math.max(subLength, high - low);
            } else {
                // When a duplicate is found, start removing characters from the left
                vessel.remove(s.charAt(low));
                low++;
            }
        }

        return subLength;  // Return the length of the longest substring

        //Another Approach
        // if(s.length() == 0) return 0;

        // int subLength = 0;

        // int low = 0;
        // int high = 0;

        // HashSet<Character> set = new HashSet<>();

        // while(high < s.length()) {
        //     if(!set.contains(s.charAt(high))) {
        //         set.add(s.charAt(high++));
        //     }
        //     while(high < s.length() && low < high && set.contains(s.charAt(high))) {
        //         int currSubLength = high - low;

        //         set.remove(s.charAt(low));
        //         low++;

        //         subLength = Math.max(currSubLength, subLength);
        //     }
        //     subLength = Math.max(high - low, subLength);
        // }

        // return subLength;
    }
}
