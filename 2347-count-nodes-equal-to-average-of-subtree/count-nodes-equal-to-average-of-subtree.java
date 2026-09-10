/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    int sum=0;
    int res=0; 
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        dfs(root.left);
        sum+=root.val;
        count++;
        dfs(root.right);
        return sum;
    }
    public int averageOfSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        count=0;
        sum=0;
        dfs(root);
         
        if(sum/count==root.val){
            res++;
        }
        averageOfSubtree(root.left);
        averageOfSubtree(root.right);
        return res;

    }
}