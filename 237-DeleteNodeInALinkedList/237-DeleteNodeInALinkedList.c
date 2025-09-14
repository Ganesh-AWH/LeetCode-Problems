// Last updated: 9/14/2025, 9:15:19 AM
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void deleteNode(struct ListNode* node) {
    node->val=node->next->val;
    node->next=node->next->next;
}