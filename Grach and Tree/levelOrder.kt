
fun levelOrder(root: TreeNode?): MutableList<Int> {
  val queue = LinkedList<TreeNode?>()
  queue.add(root)
  vallist = mutableListOf<Int>()
  while(queue.usNotEmpty()) {
    val node = queue.poll()
    list.add(node?._val!!)
    if(node.left != null) 
      queue.offer(node.left)
    if(node.right != null)
      queue.offer(node.right)
        
  }
  return list
}
