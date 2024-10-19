package LeetCode.Medium;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Create a support node to simplify edge cases, pointing to the head of the list
        ListNode supportNode = new ListNode(0);
        supportNode.next = head;
    
        ListNode prev = supportNode;  // Pointer to the node before the section to reverse
        ListNode currNode = head;      // Pointer to the current node being processed
    
        // Move prev to the node just before the 'left' position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
            currNode = currNode.next;
        }
    
        ListNode secondHead = currNode; // Store the head of the section to be reversed
    
        ListNode preNode = null; // Pointer to track the previous node during reversal
        // Reverse the nodes between 'left' and 'right'
        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = currNode.next; // Store the next node
            currNode.next = preNode;            // Reverse the link
            preNode = currNode;                 // Move preNode to current
            currNode = nextNode;                // Move to the next node
        }
    
        // Connect the end of the reversed section to the next node
        prev.next = preNode;        // Connect the node before 'left' to the new head of the reversed section
        secondHead.next = currNode; // Connect the original head of the reversed section to the node after 'right'
    
        return supportNode.next; // Return the new head of the modified list
    }
}