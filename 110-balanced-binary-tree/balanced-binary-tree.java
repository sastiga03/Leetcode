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
    int diff=0;
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        diff=Math.max(diff,Math.abs(left-right));
        return 1+Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        if(diff<=1){
            return true;
        }
        else{
            return false;
        }
    }
}