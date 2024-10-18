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
    TreeNode xParent;
    TreeNode yParent;
    int xDepth;
    int yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root, x, y, 0, null);
        return xParent != yParent && xDepth == yDepth;
    }
    private void dfs(TreeNode root, int x, int y,int depth, TreeNode parent) {
        if (root == null) return;
        if (x == root.val) {
            xParent = parent;
            xDepth = depth;
        }
        if (y == root.val) {
            yParent = parent;
            yDepth = depth;
        }
        parent = root;
        dfs(root.left, x, y, depth + 1, parent);
        dfs(root.right, x, y, depth + 1, parent);
    }
}
