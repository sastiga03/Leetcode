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

    public void dfs(List<String>res,String ans,TreeNode root){
        ans+=root.val;
        if(root==null){
            return;
        }
        if(root.left==null &&root.right==null){
            res.add(ans);
            return;
        }
        ans+="->";
        if(root.left!=null){
            dfs(res,ans,root.left);
        }
        if(root.right!=null){
            dfs(res,ans,root.right);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>res=new ArrayList<>();
        if(root==null){
            return null;
        }
        dfs(res,"",root);
        return res;
    }
}