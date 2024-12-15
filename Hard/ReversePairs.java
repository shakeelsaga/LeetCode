package LeetCode.Hard;

public class ReversePairs {
    public static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ ei - si + 1];

        int indx1 = si;
        int indx2 = mid + 1;
        int x = 0;

        while( indx1 <= mid && indx2 <= ei ) {
            if( arr[indx1] <= arr[indx2] ) {
                merged[x++] = arr[indx1++];
            } else {
                merged[x++] = arr[indx2++];
            } 
        } 

        while( indx1 <= mid ) {
            merged[x++] = arr[indx1++];
        }

        while( indx2 <= ei ) {
            merged[x++] = arr[indx2++];
        }

        for(int i = 0, j = si; i < merged.length; i++, j++ ) {
            arr[j] = merged[i];
        }

    }

    public static int pairs(int[] arr, int si, int mid, int ei) {
        int count = 0;
        int ssi = mid + 1;
        for(int i = si; i <= mid; i++) {
            while(ssi <= ei && arr[i] > 2L * arr[ssi]) {
               ssi++;   
            }
            count = count + (ssi - (mid + 1));
        }
        return count;
    }

    public static int divide(int arr[], int si, int ei) {
        int count = 0;
        if(si >= ei) {
            return count;
        }
        int mid = si + ( ei - si ) / 2;
        count += divide(arr, si, mid);
        count += divide(arr, mid + 1, ei);
        count += pairs(arr, si, mid, ei);
        conquer(arr, si, mid, ei);
        return count;
    }

    public int reversePairs(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }
}
