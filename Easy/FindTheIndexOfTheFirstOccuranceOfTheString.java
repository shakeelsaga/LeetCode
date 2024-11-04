package LeetCode.Easy;

public class FindTheIndexOfTheFirstOccuranceOfTheString {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int firstIndex = -1;
        int i = 0, j = 0;

        // Loop through the haystack
        while (i < haystack.length()) {
            char c1 = haystack.charAt(i);
            char c2 = needle.charAt(j);

            // Check if current characters match
            if (c1 == c2) {
                if (firstIndex < 0) firstIndex = i;  // Mark first match
                i++;
                j++;

                // Return if the full needle is found
                if (j == needle.length()) return firstIndex;
            } else {
                // Reset indices after mismatch
                if (firstIndex > -1) {
                    i = firstIndex;
                    j = 0;
                    firstIndex = -1;
                }
                i++;
            }
        }

        return -1;  // No match found
    }
}
