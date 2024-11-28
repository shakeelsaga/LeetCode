package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        int count1 = 0, count2 = 0;
        Integer majo1 = null, majo2 = null;

        // Find potential majority elements
        for (int num : nums) {
            if (majo1 != null && num == majo1) {
                count1++;
            } else if (majo2 != null && num == majo2) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                majo1 = num;
            } else if (count2 == 0) {
                count2 = 1;
                majo2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        // Verify if candidates are actual majority elements
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (majo1 != null && num == majo1) {
                count1++;
            } else if (majo2 != null && num == majo2) {
                count2++;
            }
        }

        // Add valid majority elements to the list
        if (majo1 != null && count1 > n / 3) list.add(majo1);
        if (majo2 != null && count2 > n / 3) list.add(majo2);

        Collections.sort(list);

        return list;
    }
}
