//队列数据结构实现
public class Queue<T>{
    private static class Queue<T>{
        private T data;
        private QueueNode<T> next;
        public QueueNode(T data){
            this.data = data;
        }
    }
    //队列头
    private QueueNode<T> first;
    //队列尾
    private QueueNode<T> last;
    //添加元素到元素尾部
    public void add(T item){
        QueueNode<T> t = new QueueNode<T>(item);
        if(last.next != null){
            last.next = t;
        }
        last = t;
        if(first == null){
            first = last;
        }
    }
    //移除并返回队列头部的元素
    public T remove(){
        if(first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if(first == null){
            last = null;
        }
        return data;
    }
    //返回队列头部的元素，但是不移除
    public T peek(){
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return first == null;
    }
    //测试用例
    public static void main(String[] args){
        Queue<Integer> queue = new Queue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("队列头部元素", + queue.peek());
        System.out.prinln("移除队列头部元素" + queue.remove());
        System.out.println("队列是否为空：" + queue.isEmpty()); //false
    }
### O(N) 会导致出队操作效率低;可以考虑采用front指向队首元素的索引，记录队列的长度，定义rear = front + size.
### 数组中包含元素的有效区为[front，rear - 1]，时间复杂度为O(1)    

    
}
