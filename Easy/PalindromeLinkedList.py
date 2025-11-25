class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head
        premid = None

        while fast and fast.next:
            premid = slow
            slow = slow.next
            fast = fast.next.next

        curr = slow
        prev = None
        while curr.next:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        curr.next = prev

        ind1 = head
        ind2 = curr

        while ind1 != slow:
            if ind1.val != ind2.val:
                return False
            ind1 = ind1.next
            ind2 = ind2.next

        return True