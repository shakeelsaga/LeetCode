package LeetCode.Medium;

import java.util.Arrays;

public class KokoEatingBananas {
    private static boolean check(int arr[], int mid, int h) {
        int hours = 0;

        for (int bananas : arr) {
            // Calculate hours needed to eat all bananas at speed mid
            hours += (bananas + (long)mid - 1) / mid;

            // Exit early if hours exceed limit h
            if (hours > h) {
                return false;
            }
        }
        
        return (hours <= h);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        // Binary search for minimum eating speed
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(piles, mid, h)) {
                high = mid - 1;  // Try slower speed
            } else {
                low = mid + 1;  // Increase speed
            }
        }

        return low;  // Minimum valid eating speed
    }
}
