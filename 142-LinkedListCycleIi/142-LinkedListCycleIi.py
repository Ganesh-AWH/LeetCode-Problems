# Last updated: 9/14/2025, 9:16:33 AM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        node=head
        visited=set()
        while(node is not None):
            if node in visited:
                return node
            visited.add(node)
            node=node.next
        return None