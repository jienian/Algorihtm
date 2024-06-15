//自定义栈的实现
public class Stack<T>{
    //内部节点类
    private static class StackNode<T>{
        //节点数据
        private T data;
        //下一个节点的引用
        private StackNode<T> next;
        public StackNode<T data>{
            this.data = data;
        }
    }
    
    //栈顶元素
    private StackNode<T> top;
    //出栈操作
    public T pop(){
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }
    //入栈操作
    public void push(T item){
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }
    //查看栈顶元素
    public T peek(){
        if(top == null) throw EmptyStackException();
        return top.data;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return top == null;
    }
//测试代码
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());//3
        System.out.println(stack.peek());//2
        System.out.println(stack.isEmpty());//false


    }
}
