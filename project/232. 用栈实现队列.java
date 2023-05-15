




//注释版
class MyQueue {
    Deque<Integer> inStack;   // 用于入队操作的栈
    Deque<Integer> outStack;  // 用于出队操作的栈

    public MyQueue() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        inStack.push(x);  // 将元素 x 入队，直接压入入队栈 inStack
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();  // 如果出队栈 outStack 为空，则将入队栈的元素转移到出队栈
        }
        return outStack.pop();  // 执行出队操作，即从 outStack 出栈
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();  // 如果出队栈 outStack 为空，则将入队栈的元素转移到出队栈
        }
        return outStack.peek();  // 查看出队栈的栈顶元素，但不执行出栈操作
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();  // 当入队栈和出队栈都为空时，队列为空
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());  // 将入队栈的元素逐个出栈并压入出队栈
        }
    }
}
