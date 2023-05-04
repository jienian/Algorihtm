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
    public boolean isSame(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;   
        if(t1 == null || t2 == null) return false;
            return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2){
        if(t1 == null) return t2 == null;
        return isSame(t1, t2)|| checkSubTree(t1.left,t2) || checkSubTree(t1.right, t2);
    }

}