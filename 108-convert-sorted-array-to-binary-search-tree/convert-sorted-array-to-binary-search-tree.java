class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode newnode = new TreeNode(nums[mid]);
        newnode.left = build(nums, left, mid - 1);
        newnode.right = build(nums, mid + 1, right);
        return newnode;
    }
}