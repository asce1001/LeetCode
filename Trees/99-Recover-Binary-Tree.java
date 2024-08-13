/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  boolean flag;
  TreeNode one = null;
  TreeNode two = null;
  TreeNode prev;

  public void recoverTree(TreeNode root) {
    if (root == null)
      return;
    helper(root);
    int temp = 0;
    temp = one.val;
    one.val = two.val;
    two.val = temp;
  }

  private void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.left);
    if (prev != null && prev.val > root.val) {
      if (!flag) {
        one = prev;
        two = root;
        flag = true;
      } else {
        two = root;
      }
    }
    prev = root;
    helper(root.right);
  }
}
