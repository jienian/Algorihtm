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


//解法二:
class Solution {
  /**
   * 检查 t2 是否是 t1 的子树
   *
   * @param t1 树 t1
   * @param t2 树 t2
   * @return t2 是否是 t1 的子树
   */
  public boolean checkSubTree(TreeNode t1, TreeNode t2) {
    StringBuilder string1 = new StringBuilder();
    StringBuilder string2 = new StringBuilder();
    getOrderString(t1, string1);
    getOrderString(t2, string2);
    return string1.indexOf(string2.toString()) != -1;
  }

  /**
   * 按前序遍历顺序获取二叉树的字符串表示
   *
   * @param node 当前节点
   * @param sb   用于构建字符串的 StringBuilder
   */
  public void getOrderString(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append("X"); // 表示空节点
      return;
    }
    sb.append(node.val + " "); // 将节点的值加入字符串
    getOrderString(node.left, sb); // 递归处理左子树
    getOrderString(node.right, sb); // 递归处理右子树
  }
}

