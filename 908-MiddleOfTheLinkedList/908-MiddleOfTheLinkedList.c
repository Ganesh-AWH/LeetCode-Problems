// Last updated: 9/14/2025, 9:12:00 AM
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* middleNode(struct ListNode* head){
      int count=0;
      struct ListNode *temp=head;
      while(temp!=NULL){
          count++;
          temp=temp->next;
      }
      temp=head;
      int mid=count/2;
      for(int i=0;i<mid;i++){
           temp=temp->next;
      }
      return temp;
}