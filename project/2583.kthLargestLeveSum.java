``` java
//这题是LeetCode的第2583题
  //二叉树中的第 K 大层和，只需要对二叉树进行BFS遍历即可
publi long kthLargestLeveSum(TreeNode root , int k) {
		List<Long> mList = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.siez();
			long sum = 0;
			while (size -- > 0) {
				TreeNode cur = q.poll();
				sum += cur.val;
				if(cur.left != null) q.offer(cur.left);
				if(cur.right != null) q.offer(cur.right);
				}
				mList.add(sum);
			}
			if(mList.size() < k) return -1;
			Collections.sort(mList, (mList, (a , b) -> Long.compare(b, a));
			return mList.get(k - 1);
	}
```
