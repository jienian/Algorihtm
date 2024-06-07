//从上到下遍历
public List<List<Integer>> leveOrderBottom(TreeNode root) {
	if (root == null) return new ArrayList<>();
	Queue<TreeNode> queue = new LinkedList<>();
	List<List<Integer>> res = new LinkedList<>();
	queue.add(root);
	while(!queue.isEmpty()) {
		int leveCount = queue.size();
		List<Integer> subList = new ArrayList<>();
		for(int i = 0; i < levelCount; i++) {
			TreeNode node = queue.poll();
			subList.add(node.val);
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		}
		res.add(0, subList);
	}
	return res;
}