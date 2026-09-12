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
    public int dfs(TreeNode root,String res){
        if(root==null){
            return 0;
        }

        res=res+root.val;
        if(root.left==null && root.right==null){
            return Integer.parseInt(res,2);
        }
        return dfs(root.left,res)+dfs(root.right,res);
    }
    public int sumRootToLeaf(TreeNode root) {
       return dfs(root,"");
    }
}