# Last updated: 9/14/2025, 9:15:24 AM
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        next_node=node.next
        node.val=next_node.val
        node.next=next_node.next
        next_node=None
