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
    HashMap<Integer,Integer>map=new HashMap<>();
    public void dfs(TreeNode root){
        if(root==null) return;
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        dfs(root.left);
        dfs(root.right);
    }
    public int[] findMode(TreeNode root) {
        dfs(root);
        int max=0;
        for(int count:map.values()){
            max=Math.max(max,count);
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i:map.keySet()){
            if(map.get(i)==max){
                list.add(i);
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}