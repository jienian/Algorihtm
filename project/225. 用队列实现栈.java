class MyStack{
    Queue<Integer> queue;
    public MyStack(){
        queue = new LinkedList<Integer>();

    }
    public void push(int x ){
        int n = queue.size();
        queue.offer(x);
        for(int i = 0; i < n;i++){
            queue.offer(queue.poll());
        }
    }
    public int pop(){
        return queue.poll();
    }
    public int top(){
        return queue.peek();
    }
    public boolean empty(){
        return queue.isEmpty();
    }
}

class MyStack {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        // 初始化队列
        queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        
        // 将元素 x 入队
        queue.offer(x);
        
        // 将之前的元素依次出队再入队，使得新入队的元素位于队列的头部
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 出队即为栈顶元素
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        // 查看栈顶元素，但不出队
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        // 判断队列是否为空
        return queue.isEmpty();
    }
}
