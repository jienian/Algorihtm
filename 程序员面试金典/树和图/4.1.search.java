// 定义一个枚举类型来表示每个节点的访问状态
enum State { Unvisited, Visited, Visiting; }

// 方法定义：在图中搜索从start节点到end节点是否存在路径
boolean search(Graph g, Node start, Node end) {
    // 如果起始节点和目标节点是同一个节点，直接返回true，因为路径长度为0
    if (start == end) return true;

    // 创建一个队列来支持BFS的层次遍历
    LinkedList<Node> q = new LinkedList<Node>();

    // 初始化所有节点状态为Unvisited
    for (Node u : g.getNodes()) {
        u.state = State.Unvisited;
    }

    // 将起始节点状态设置为Visiting，并将其加入队列
    start.state = State.Visiting;
    q.add(start);

    Node u; // 用于在while循环中存储当前节点

    // 只要队列不为空就继续执行循环
    while (!q.isEmpty()) {
        // 从队列中移除队首元素
        u = q.removeFirst();

        // 确保当前节点不为空
        if (u != null) {
            // 遍历当前节点的所有邻接节点
            for (Node v : u.getAdjacent()) {
                // 只处理未访问过的邻接节点
                if (v.state == State.Unvisited) {
                    // 如果邻接节点是目标节点，说明找到了路径，返回true
                    if (v == end) {
                        return true;
                    } else {
                        // 否则，将邻接节点标记为正在访问，并将其加入队列
                        v.state = State.Visiting;
                        q.add(v);
                    }
                }
            }
            // 完成对当前节点的访问，将其标记为已访问
            u.state = State.Visited;
        }
    }

    // 如果队列被清空还没有找到目标节点，返回false
    return false;
}
