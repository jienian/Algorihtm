class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1); // 调用 helper 方法，返回构建好的二叉搜索树的根节点
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) { // 如果左边界大于右边界，说明没有数字需要处理，返回 null
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点，以保证左右子树的高度差不超过 1
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]); // 创建根节点
        root.left = helper(nums, left, mid - 1); // 递归构建左子树
        root.right = helper(nums, mid + 1, right); // 递归构建右子树
        return root; // 返回构建好的二叉搜索树的根节点
    }
}

