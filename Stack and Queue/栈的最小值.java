//定义一个最小栈类，用于支持常数时间内获取栈中最小元素
class MinStack{
    //存储所有元素的栈
    Deque<Integer> xStack;
    //存储最小元素的栈
    Deque<Integer> minStack;
    //构造函数，初始化最小元素栈，并往其中压入一个初始最大值
    public MinStack(){
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    //将元素x压入栈中，同时更新元素最小元素栈中的最小值
    public void push(int x){
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    //弹出栈顶元素，同时弹出最小元素栈顶的最小值
    public void pop(){
        xStack.pop();
        minStack.pop();
    }
    //返回栈顶元素
      public int top() {
        return xStack.peek();
    }
    //返回栈中的最小元素
    public int getMin(){
        return minStack.peek();
    }



    //测试
    public class Main{
        public static void main(String[] args){
            MinStack obj = new MinStack();
            obj.push(-2);
            obj.push(0);
            obj.push(-3);
            System.out.println(obj.getMin());//-3
            obj.pop();
            System.out.println(obj.top());//0
            System.out.println(obj.getMin());//-2
        }
    }
}