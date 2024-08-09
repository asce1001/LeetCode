/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  List<TreeNode> pList;
  List<TreeNode> qList;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return null;
    helper(root, p, q, new ArrayList<>());
    // System.out.println(qList.size());
    for (int i = 0; i < pList.size(); i++) {
      if (pList.get(i) != qList.get(i)) {
        return pList.get(i - 1);
      }
    }
    return null;
  }

  private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
    // base
    if (root == null)
      return;
    // logic
    if (root == p) {
      pList = new ArrayList<>(path);
      pList.add(root);
      pList.add(root);
    }
    if (root == q) {
      qList = new ArrayList<>(path);
      qList.add(root);
      qList.add(root);
    }
    // action
    path.add(root);
    // recurse
    helper(root.left, p, q, path);
    helper(root.right, p, q, path);
    // backtrack
    path.remove(path.size() - 1);
  }
}
