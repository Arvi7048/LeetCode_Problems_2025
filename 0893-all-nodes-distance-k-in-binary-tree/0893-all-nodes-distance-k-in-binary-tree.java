/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        getPathAndSearch(root, target, k);
        return result;
    }

    // Returns distance from root to target if target is in subtree, -1 otherwise
    private int getPathAndSearch(TreeNode node, TreeNode target, int k) {
        if (node == null) return -1;

        if (node == target) {
            subtreeAdd(node, 0, k);
            return 1;
        }

        int left = getPathAndSearch(node.left, target, k);
        if (left != -1) {
            if (left == k) result.add(node.val);
            subtreeAdd(node.right, left + 1, k); // go to the other side
            return left + 1;
        }

        int right = getPathAndSearch(node.right, target, k);
        if (right != -1) {
            if (right == k) result.add(node.val);
            subtreeAdd(node.left, right + 1, k); // go to the other side
            return right + 1;
        }

        return -1; // target not found in this path
    }

    private void subtreeAdd(TreeNode node, int dist, int k) {
        if (node == null) return;
        if (dist == k) {
            result.add(node.val);
            return;
        }
        subtreeAdd(node.left, dist + 1, k);
        subtreeAdd(node.right, dist + 1, k);
    }
}
