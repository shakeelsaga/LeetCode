package LeetCode.Medium;

public class RemoveNthNodeFromTheEndOfTheList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Return null if the list is empty
        if (head == null)
            return null;
    
        // If the list has only one element, return null if n is 1; otherwise, return the head
        if (head.next == null) {
            if (n == 1) {
                return null;
            } else {
                return head;
            }
        }
    
        ListNode curr = head;
        int size = 0; // Counter to track the size of the list
    
        // Calculate the size of the list
        while (curr != null) {
            size++;
            curr = curr.next;
        }
    
        // If n is equal to the size, remove the head
        if (n == size) {
            return head.next;
        }
    
        int pos = 1; // Counter for the current position in the list
        int targetPos = (size - n); // Calculate the position to remove
        curr = head;
    
        // Loop to find the node just before the target position
        while (curr.next != null) {
            if (pos == targetPos) {
                // Remove the nth node from the end
                ListNode temp = curr.next.next;
                curr.next = temp;
                return head; // Return the modified list
            }
            curr = curr.next;
            pos++;
        }
    
        return head; // Return the head if no node was removed (shouldn't happen)
    }
}