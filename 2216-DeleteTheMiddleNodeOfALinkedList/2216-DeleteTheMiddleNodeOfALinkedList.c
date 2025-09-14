// Last updated: 9/14/2025, 9:08:57 AM
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteMiddle(struct ListNode* head){
      struct  ListNode *delnode=head,*temp=head;
      if(head->next==NULL){
          head=NULL;
          return head;
      }
      int count=0;
      while(temp!=NULL){
          temp=temp->next;
          count+=1;
      }
      temp=head;
      for(int i=0;i<(count/2)-1;i++){
          temp=temp->next;
      }
      temp->next=temp->next->next;
       return head;      
}