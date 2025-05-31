class Solution {
    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inOrder(root);
        // Swap values of the two incorrect nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        // Detect swapped nodes
        if (prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;

        inOrder(root.right);
    }
}
