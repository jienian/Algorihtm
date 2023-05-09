class Solution {
    /**
     * 计算路径和等于指定值的路径数量
     *
     * @param root 树的根节点
     * @param sum  目标路径和
     * @return 路径数量
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        // 计算以当前节点为路径起点的路径数量
        int ret = rootSum(root, sum);
        
        // 递归计算左子树和右子树中路径和等于指定值的路径数量，并累加到结果中
        ret += pathSum(root.left, sum);
        ret += pathSum(root.right, sum);
        
        return ret;
    }

    /**
     * 计算以当前节点为路径起点的路径数量
     *
     * @param root 当前节点
     * @param sum  剩余需要凑成的路径和
     * @return 路径数量
     */
    public int rootSum(TreeNode root, int sum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        
        int val = root.val;
        if (val == sum) {
            // 当前节点的值等于剩余需要凑成的路径和，路径数量加一
            ret++;
        } 

        // 递归计算左子树和右子树中以当前节点为路径起点的路径数量，并累加到结果中
        ret += rootSum(root.left, sum - val);
        ret += rootSum(root.right, sum - val);
        
        return ret;
    }

//main
    public static void main(String[] args) {
        // 构建一棵二叉树
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        
        int targetSum = 8;
        
        Solution solution = new Solution();
        int pathCount = solution.pathSum(root, targetSum);
        
        System.out.println("路径和等于 " + targetSum + " 的路径数量为：" + pathCount);
    }
}

}
