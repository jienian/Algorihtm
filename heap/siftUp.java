/* 元素入堆 */
public void push(int val) {
    // 添加节点
    maxHeap.add(val);
    // 从底至顶堆化
    siftUp(size() - 1);
}

/* 从节点 i 开始，从底至顶堆化 */
public void siftUp(int i) {
    while (true) {
        // 获取节点 i 的父节点
        int p = parent(i);
        // 当“越过根节点”或“节点无须修复”时，结束堆化
        if (p < 0 || maxHeap.get(i) <= maxHeap.get(p))
            break;
        // 交换两节点
        swap(i, p);
        // 循环向上堆化
        i = p;
    }
}
