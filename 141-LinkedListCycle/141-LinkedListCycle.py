# Last updated: 9/14/2025, 9:16:36 AM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        node=head
        visited=set()
        while node is not None:
            if node  in visited:
                return True
            visited.add(node)
            node=node.next
        return False