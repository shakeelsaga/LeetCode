package LeetCode.Medium;

public class DeletetheMiddleNodeofaLinkedList {

    public ListNode deleteMiddle(ListNode head) {
    // Return null if the list is empty or has only one element
    if (head == null || head.next == null) {
        return null;
    }

    ListNode fast = head.next.next; // Fast pointer for traversing the list
    ListNode slow = head;            // Slow pointer to find the middle

    // Loop to find the middle node
    while (fast != null && fast.next != null) {
        slow = slow.next;            // Move slow one step
        fast = fast.next.next;      // Move fast two steps
    }
    
    // Skip the middle node
    slow.next = slow.next.next;

    return head; // Return the modified list
}
}
