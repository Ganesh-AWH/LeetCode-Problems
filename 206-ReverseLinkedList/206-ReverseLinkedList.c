// Last updated: 9/14/2025, 9:15:47 AM
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head){
       struct ListNode *prev=NULL,*curr=head,*nxt;
       while(curr!=NULL){
           nxt=curr->next;
           curr->next=prev;
           prev=curr;
           curr=nxt;
       }
       return prev;
}
// 1 -> 2 -> 3 -> 4 -> NULL
// NULL <- 1 <- 2 <- 3 <- 4