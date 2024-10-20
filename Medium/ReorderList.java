package LeetCode.Medium;

public class ReorderList {
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
    
        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow.next; // Start reversing from the node after the middle
        slow.next = null; // Disconnect the first half from the second half
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    
        // Step 3: Merge the two halves
        ListNode list1 = head;
        ListNode list2 = prev; // This is the head of the reversed second half
    
        while (list2 != null) { // Merge until the second half is fully interleaved
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;
            list1.next = list2; // Point first half's current node to second half's current node
            list2.next = temp1; // Point second half's current node to the next node of the first half
            list1 = temp1;      // Move to the next node in the first half
            list2 = temp2;      // Move to the next node in the second half
        }
    }
}
