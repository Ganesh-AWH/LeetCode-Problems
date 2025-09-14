// Last updated: 9/14/2025, 9:13:12 AM
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* mergeTrees(struct TreeNode* root1, struct TreeNode* root2){
          if(root1 && root2){
              root1->val+=root2->val;
              root1->left=mergeTrees(root1->left,root2->left);
              root1->right=mergeTrees(root1->right, root2->right);
              return root1;
          }
          if(root1){
              return root1;
          }
          else{
              return root2;
          }
}