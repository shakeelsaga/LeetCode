class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
        
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        temp = ListNode(-1)
        temp.next = head

        i = temp
        j = temp

        for x in range(n + 1):
            j = j.next
        
        while j:
            i = i.next
            j = j.next

        i.next = i.next.next

        return temp.next