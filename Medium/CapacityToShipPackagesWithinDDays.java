package LeetCode.Medium;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {
    private static boolean canShip(int arr[], int mid, int days) {
        int day = 1;
        int weight = 0;
        for(int i : arr) {
            weight += i;  // Add current weight to the total
            if(weight > mid) {  // If weight exceeds capacity
                weight = i;  // Start new day with current item
                day++;  // Increment day count
            }

            if(day > days) {  // If days exceed threshold
                return false;
            }
        }

        return day <= days;  // Return true if within days limit
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();  // Maximum package weight
        int high = 0;

        for(int i : weights) {
            high += i;  // Sum of all weights
        }

        while(low < high) {
            int mid = low + (high - low)/2;  // Midpoint of current weight range

            if(canShip(weights, mid, days)) {  // Check if shipping is possible with mid capacity
                high = mid;  // Try smaller capacity
            } else {
                low = mid + 1;  // Increase capacity
            }
        }

        return low;  // Return the smallest valid capacity
    }
}
