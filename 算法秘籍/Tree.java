class Tree{
    public Node root;
}

//中序遍历
void inOrderTraversal(TreeNode node){
    if(node != null){
        inOrderTraversal(node.left);
        visit(node);
        inOrderTraversal(node.right);
    }
}

//前序遍历
void preOrderTraversal(TreeNode node){
    if(node != null){
        visit(node);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}
//后序遍历
void postOrderTraversal(TreeNode node){
    if(node != null){
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        postOrderTraversal(node);
    }
}

