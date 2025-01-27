package LeetCode.Medium;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        s = s.trim();
        
        // Split the string by spaces into an array of words
        String[] words = s.split("\\s+");
        
        // Reverse the array of words
        StringBuilder reversed = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }
        
        return reversed.toString();
    }
}
