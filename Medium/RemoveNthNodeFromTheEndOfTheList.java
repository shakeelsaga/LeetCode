public class RemoveNthNodeFromTheEndOfTheList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        if (head.next == null) {
            if (n == 1) {
                return null;
            } else {
                return head;
            }
        }
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        if(n == size) {
            return head.next;
        }

        int pos = 1, targetPos = (size - n);
        curr = head;

        while (curr.next != null) {
            if (pos == targetPos) {
                ListNode temp = curr.next.next;
                curr.next = temp;
                return head;
            }
            curr = curr.next;
            pos++;
        }

        return head;
    }
}