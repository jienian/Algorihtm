class Solution {
    int ans; // 用来记录第二小的节点值
    int rootvalue; // 用来记录根节点的值

    public int findSecondMinimumValue(TreeNode root) {
        ans = -1; // 初始化ans为-1
        rootvalue = root.val; // 记录根节点的值
        dfs(root); // 递归查找第二小的值
        return ans; // 返回第二小的值
    }

    public void dfs(TreeNode node) {
        if (node == null) { // 如果节点为空，则返回
            return;
        }
        if (ans != -1 && node.val >= ans) { // 如果当前节点的值大于等于ans，则返回
            return;
        }
        if (node.val > rootvalue) { // 如果当前节点的值大于根节点的值，说明是比根节点大的值，更新ans
            ans = node.val;
        }
        dfs(node.left); // 递归查找左子树
        dfs(node.right); // 递归查找右子树
    }
}
