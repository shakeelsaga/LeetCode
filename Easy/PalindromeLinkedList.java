package LeetCode.Easy;

public class PalindromeLinkedList {
    
    public boolean isPalindrome(ListNode head) {
        // Returns false if the list is empty
        if (head == null) return false; 
        // Returns true if the list has only one element
        if (head.next == null) return true; 

        ListNode fast = head.next.next; 
        ListNode slow = head;
        int mid = 1; // Counter to calculate the middle position
        
        // This loop will help in finding the middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            mid++;
        }

        // Reversing the second half of the list
        ListNode prev = slow.next;  // Starting point for reversal
        ListNode curr = slow.next.next; // The next node to process
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Set the end of the first half to avoid cycles
        slow.next = null;

        // Checking for palindromic values between the first half and the second half
        fast = prev;   // Start of the reversed second half
        slow = head;   // Start of the first half
        for (int i = 0; i < mid; i++) { // This will ignore the middle element when the list is odd
            if (slow.val != fast.val) {
                return false; // Returns false if any number doesn't match
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return true; // Returns true if all the numbers match
    }
}
