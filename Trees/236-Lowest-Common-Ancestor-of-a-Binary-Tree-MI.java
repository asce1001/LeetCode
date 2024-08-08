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
    List<TreeNode> pList = new ArrayList<>();
    List<TreeNode> qList = new ArrayList<>();
    boolean flagP = true;
    boolean flagQ = true;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        //return pList.get(  );
        for(int i = 0; i < pList.size(); i++){
            System.out.println(pList.get(i).val + " " + qList.get(i).val);
            if(pList.get(i).val == qList.get(i).val){
                continue;
            } else return pList.get(i - 1);
        }
        //System.out.println(qList.size());
        // for(int i = 0; i < pList.size(); i++){
        //     System.out.println(pList.get(i).val + " " + qList.get(i).val);
        //     if(!pList.get(i).equals(qList.get(i))) {
        //         System.out.println("here");
        //         return pList.get(i - 1);
        //     }
        // }
        return null;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return;
        if(flagP) pList.add(root);
        if(flagQ) qList.add(root);
        if(root.val == p.val){
            pList.add(root);
            flagP = false;
        }
        if(root.val == q.val){
            qList.add(root);
            flagQ = false;
        }
        helper(root.left, p, q);
        helper(root.right, p, q);
        if(flagP) pList.remove(pList.size() - 1);
        if(flagQ) qList.remove(qList.size() - 1);
    }
}
