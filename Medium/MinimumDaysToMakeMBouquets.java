package LeetCode.Medium;

public class MinimumDaysToMakeMBouquets {
    private static boolean check(int arr[], int mid, int m, int k) {
        int boq = 0;
        int flowers = 0;

        for(int i : arr) {
            if(i <= mid) {
                flowers++;
            } else {
                boq += (flowers/k);
                flowers = 0;
            }
        }

        boq += (flowers/k);

        return (boq >= m);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowers = (long) m * k;
        int n = bloomDay.length;
        if(n < totalFlowers) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] >= high) {
                high = bloomDay[i];
            } 
            if(bloomDay[i] < low) {
                low = bloomDay[i];
            }
        }

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(check(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
