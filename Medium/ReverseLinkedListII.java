package LeetCode.Medium;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode supportNode = new ListNode(0);
        supportNode.next = head;

        ListNode prev = supportNode;
        ListNode currNode = head;

        for (int i = 0; i < left - 1; i++) {
        prev = prev.next;
        currNode = currNode.next;
        }

        ListNode secondHead = currNode;

        ListNode preNode = null;
        for (int i = 0; i <= right - left; i++) {
        ListNode nextNode = currNode.next;
        currNode.next = preNode;
        preNode = currNode;
        currNode = nextNode;
        }

        prev.next = preNode;
        secondHead.next = currNode;

        return supportNode.next;
    }
}