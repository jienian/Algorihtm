 
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>(); // 创建一个栈，用于保存访问过的节点
        TreeNode prev = null, curr = root; // 初始化prev为null，curr为根节点root
        while (!stack.isEmpty() || curr != null) { // 如果栈不为空或者当前节点不为空
            while (curr != null) { // 如果当前节点不为空
                stack.push(curr); // 将当前节点压入栈中
                curr = curr.left; // 继续遍历左子树
            }
            curr = stack.pop(); // 从栈中弹出一个节点
            if (prev == p) { // 如果上一个节点是p节点
                return curr; // 返回当前节点
            }
            prev = curr; // 将当前节点设为上一个节点
            curr = curr.right; // 继续遍历右子树
        }
        return null; // 如果未找到后继节点，返回null
    }
}

