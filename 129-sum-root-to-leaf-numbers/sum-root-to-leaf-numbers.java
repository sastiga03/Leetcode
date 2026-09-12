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
    public int dfs(TreeNode root,String path){
        if(root==null){
            return 0;
        }
        path+=root.val;
        if(root.left==null  && root.right==null){
            return Integer.parseInt(path);
        }
        return dfs(root.left,path)+dfs(root.right,path);
    }
    public int sumNumbers(TreeNode root) {
       return dfs(root,"");
    }
}