// Last updated: 9/14/2025, 9:17:04 AM
/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     struct Node *left;
 *     struct Node *right;
 *     struct Node *next;
 * };
 */

struct Node* connect(struct Node* root) {
    if(root==NULL){
        return root;
    }
    struct Node *curr=root;
    while(curr->left!=NULL){
        struct Node *temp=curr;
        while(curr!=NULL){
            curr->left->next=curr->right;
            curr->right->next=curr->next==NULL?NULL:curr->next->left;
            curr=curr->next;
        }
        curr=temp->left;
    }
	return root;
}