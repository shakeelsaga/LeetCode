package LeetCode.Easy;

public class SecondLargestDigitInAString {
    public int secondHighest(String s) {
        if(s.length() == 0) return -1; // Handle empty string case

        int largest = Integer.MIN_VALUE;
        int secondL = -1;

        int i = 0;
        while(i < s.length()) {
            // Check if the character is not an alphabet
            if(!(Character.isAlphabetic(s.charAt(i)))) {
                int curr = Character.getNumericValue(s.charAt(i)); // Convert char to integer

                // Update largest and second largest
                if(curr > largest) {
                    secondL = largest;
                    largest = curr;
                } else if(curr > secondL && curr != largest) {
                    secondL = curr;
                }
            }
            i++;
        }
        return (secondL == -1 || secondL == Integer.MIN_VALUE) ? -1 : secondL; // Return second largest or -1 if not found
    }
}
