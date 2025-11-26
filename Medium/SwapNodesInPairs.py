# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        length = 0
        curr = head

        while curr:
            length = length + 1
            curr = curr.next

        dummy = ListNode(-1)
        dummy.next = head

        curr = head
        prevPair = dummy

        for x in range(length // 2):
            prev = None
            tail = curr
            
            for y in range(2):
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            
            prevPair.next = prev
            tail.next = curr

            prevPair = tail


        return dummy.next