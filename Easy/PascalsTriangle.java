package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> list = new ArrayList<>();

    // Iterate through each row
    for (int i = 0; i < numRows; i++) {
        List<Integer> temp = new ArrayList<>(i + 1);

        // Fill in values for each column in the row
        for (int j = 0; j < i + 1; j++) {
            if (j == 0 || j == i) {
                temp.add(1); // First and last elements are always 1
            } else {
                // Sum of two elements from the previous row
                int num = (list.get(i - 1).get(j - 1)) + (list.get(i - 1).get(j));
                temp.add(num);
            }
        }
        list.add(temp); // Add the current row to the list
    }

    return list;
}
}
