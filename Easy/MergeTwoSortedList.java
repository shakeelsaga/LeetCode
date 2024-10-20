package LeetCode.Easy;

public class MergeTwoSortedList {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // Dummy node to start the merged list
        ListNode prev = dummy;

        // Merge lists while both have nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;  // Attach list1's node
                list1 = list1.next; // Move to next node in list1
            } else {
                prev.next = list2;  // Attach list2's node
                list2 = list2.next; // Move to next node in list2
            }
            prev = prev.next;       // Move to next in merged list
        }

        // Attach remaining nodes
        if (list1 != null) {
            prev.next = list1;
        } else {
            prev.next = list2;
        }

        return dummy.next; // Return merged list, skipping dummy
    }
}
