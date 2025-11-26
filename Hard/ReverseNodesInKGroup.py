class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        length = 0
        curr = head

        while curr:
            length = length + 1
            curr = curr.next

        groupSize = length // k

        dummy = ListNode(-1)
        curr = head

        
        prevGroup = dummy

        for x in range(groupSize):
            prev = None
            tail = curr

            for _ in range(k):
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            
            prevGroup.next = prev
            tail.next = curr
            
            prevGroup = tail

        
        return dummy.next