package LeetCode.Easy;

public class LinkedListCycle {
    
    public class Solution {
        public boolean hasCycle(ListNode head) {
        // Edge case: if the list is empty or has only one node, no cycle is possible
        if (head == null || head.next == null) return false;
    
        // Initialize fastNode two steps ahead and slowNode at the head
        ListNode fastNode = head.next.next;
        ListNode slowNode = head;
    
        // Traverse the list while fastNode and fastNode.next are not null
        while (fastNode != null && fastNode.next != null) {
            // If fastNode meets slowNode, there's a cycle
            if (fastNode == slowNode) { 
                return true;  // Cycle detected
            } else {
                // Move slowNode by 1 step and fastNode by 2 steps
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            }
        }
    
        return false;  // No cycle found
    }
    
    //////////////////////////
    // Alternative HashSet method (commented out)
    //////////////////////////
    
    // public boolean hasCycle(ListNode head) {
    //     // Edge case: no cycle if the list is empty or has one node
    //     if (head == null || head.next == null) return false;
    
    //     ListNode curr = head;
    //     HashSet<ListNode> set = new HashSet<>();  // To store visited nodes
    
    //     // Traverse the list and check if any node repeats
    //     while (curr != null) {
    //         if (set.contains(curr)) {
    //             return true;  // Cycle detected
    //         } else {
    //             set.add(curr);  // Add current node to the set
    //             curr = curr.next;  // Move to the next node
    //         }
    //     }
    
    //     return false;  // No cycle found
    // }
    }
}
