class Grach{
    public Node[] nodes;
}
class Node{
    public String name;
    public Node[] children;
}
//DFS
void search(Node root){
    if(root == null) return;
    visit(root);
    root.visited = true;
    for each(Node n in root.adjcent){
        if(n.visited == false){
            search(n);
        }
    }
}
//BFS
void search(Node root){
    QUeue Queue = new Queue();
    root.marked = true;
    queue.enqueue(root);
    while(!queue.isEmpty()){
        Node r = queue.dequeue();
        visit(r);
        foreach(Node n in r.adjacent){
            if(n.marked == false){
                n.marked = true;
                queue.enqueue(n);
            }
        }
    }
}