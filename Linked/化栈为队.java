import java.util.Deque;
import java.util.LinkedList;

class MyQueue {
    Deque<Integer> inStack; // 用于入队操作的栈
    Deque<Integer> outStack; // 用于出队操作的栈

    public MyQueue() {
        inStack = new LinkedList<Integer>(); // 初始化入队栈
        outStack = new LinkedList<Integer>(); // 初始化出队栈
    }

    public void push(int x) {
        inStack.push(x); // 入队操作，将元素放入入队栈顶
    }

    public int pop() {
        if (outStack.isEmpty()) { // 如果出队栈为空
            in2out(); // 将入队栈中的元素转移到出队栈中
        }
        return outStack.pop(); // 出队操作，从出队栈顶弹出元素
    }

    public int peek() {
        if (outStack.isEmpty()) { // 如果出队栈为空
            in2out(); // 将入队栈中的元素转移到出队栈中
        }
        return outStack.peek(); // 查看出队栈顶的元素，但不进行出队操作
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty(); // 判断队列是否为空
    }

    private void in2out() {
        while (!inStack.isEmpty()) { // 当入队栈不为空时
            outStack.push(inStack.pop()); // 将入队栈顶的元素弹出并放入出队栈顶
        }
    }
}
