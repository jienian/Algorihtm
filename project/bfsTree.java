    public void bfsTree(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEpty()) {
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                Tree cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
    }

