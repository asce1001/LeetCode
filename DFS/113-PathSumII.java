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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int sum, List<Integer> path){
        if(root == null) return;
        path.add(root.val);
        sum += root.val;
        helper(root.left, targetSum, sum, path);
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                result.add(new ArrayList<>(path));
                //return;
            }
        }
        helper(root.right, targetSum, sum, path);
        path.remove(path.size() - 1);

    }
}
