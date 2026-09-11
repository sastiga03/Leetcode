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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>arr1=new ArrayList<>();
        List<Integer>arr2=new ArrayList<>();
        ans(root1,arr1);
        ans(root2,arr2);
        return arr1.equals(arr2);
    }
    public void ans(TreeNode root,List<Integer>list){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        ans(root.left,list);
        ans(root.right,list);
    }
}