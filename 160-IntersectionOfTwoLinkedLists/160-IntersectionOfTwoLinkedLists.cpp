// Last updated: 9/14/2025, 9:16:16 AM
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        stack<ListNode *>s1,s2;
        while(headA!=NULL){
            s1.push(headA);
            headA=headA->next;
        }
        while(headB!=NULL){
            s2.push(headB);
            headB=headB->next;
        }
        if(s1.top()!=s2.top()){return NULL;}
        ListNode *temp;
        while(!s1.empty() && !s2.empty()){
            if(s1.top()!=s2.top()){
                break;
            }
            temp=s1.top();
            s1.pop();
            s2.pop();
        }
        return temp;
    }
};