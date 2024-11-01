package LeetCode.Medium;

public class AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headPointer = new ListNode(); // Node pointing to the new head
        ListNode temp = headPointer; // Pointer for result list
        int carry = 0;

        // Traverse l1 && l2
        while(l1 != null || l2 != null) {
            int val1 = (l1 != null)? l1.val : 0; // If l1 is not null, get its value; otherwise 0
            int val2 = (l2 != null)? l2.val : 0; // If l2 is not null, get its value; otherwise 0
            int sum = carry + val1 + val2; // Calculate the sum along wit hthe carry
            carry = sum / 10;// Get the next carry

            temp.next = new ListNode(sum % 10);// Create a new node for the result list
            temp = temp.next;// Move to the next node

            // Move to the next node in l1 and l2 if they exist
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        // If there's still a carry left after the loop, append it
        if(carry > 0) {
            temp.next = new ListNode(carry);
        }

        return headPointer.next; // Return the next node after dummy (i.e., the result list head)
    }
}
