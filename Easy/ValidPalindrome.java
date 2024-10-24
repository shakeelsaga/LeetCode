package LeetCode.Easy;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase(); // Convert the string to lowercase for case-insensitive comparison
        int i = 0, j = s.length() - 1; // Initialize two pointers: i at the start and j at the end of the string
        while (i < j) {
            // Move 'i' forward if the current character is not alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Move 'j' backward if the current character is not alphanumeric
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            // If characters at 'i' and 'j' don't match, it's not a palindrome
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            // Move both pointers inward to continue checking
            i++;
            j--;
        }
        // If all characters matched, the string is a palindrome
        return true;
    }    
}