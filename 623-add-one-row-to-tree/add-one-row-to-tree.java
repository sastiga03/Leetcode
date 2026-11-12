
class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        // Special case: Insert at depth 1
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        preorder(root, val, 1, depth);

        return root;
    }

    public void preorder(TreeNode root, int val, int level, int depth) {

        // Base case
        if (root == null) {
            return;
        }

        // Reach the parent level
        if (level == depth - 1) {

            TreeNode leftNode = new TreeNode(val);
            TreeNode rightNode = new TreeNode(val);

            // Preserve original children
            leftNode.left = root.left;
            rightNode.right = root.right;

            // Attach new nodes
            root.left = leftNode;
            root.right = rightNode;

            return;
        }

        // Preorder: Root → Left → Right
        preorder(root.left, val, level + 1, depth);
        preorder(root.right, val, level + 1, depth);
    }
}
