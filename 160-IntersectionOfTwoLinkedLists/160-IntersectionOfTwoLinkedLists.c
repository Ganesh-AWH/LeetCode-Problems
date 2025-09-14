// Last updated: 9/14/2025, 9:16:20 AM
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

 /*
 int length(struct ListNode *temp){
     int len=0;
     while(temp!=NULL){
         ++len;
         temp=temp->next;
     }
     return len;
 }
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
       int length1 = length(headA);
       int length2 = length(headB);
       while(length1>length2){
           headA=headA->next;
           length1--;
       }
       while(length2>length1){
           headB=headB->next;
           length2--;
       }
       while(headA!=headB){
           headA=headA->next;
           headB=headB->next;
       }
       return headA;
}
*/

//Approach-2
//Tc = O(n^2)
//sc = O(1)

struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
      struct ListNode *temp;
      while(headA!=NULL){
            temp=headB;
            while(temp!=NULL){
                if(headA==temp){
                    return temp;
                }
                temp=temp->next;
            }
            headA=headA->next;
      }
      return NULL;
}

