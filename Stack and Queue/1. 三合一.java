class TripleInOne{
    private int[] arr;
    private int[] ptrs;
    private int  stackSize;

    public TripleInOne(int stackSize){
        this.stackSize = stackSize;
        arr = new int[3 * stackSize];

        ptrs = new int[3];
        ptrs[0] = 0;
        ptrs[1] = stackSize;
        ptrs[2] = stackSize * 2;
    }
    public void push(int stackNum, int value){
        if(ptrs[stackNum] < (stackNum + 1) * stackSize){
            arr[ptrs[stackNum]] = value;
            ptrs[stackNum]++;
        }
    }
    public int pop(int stackNum){
        if(isEmpty(stackNum)) return -1;
        ptrs[stackNum]--;
        return arr[ptrs[stackNum]];
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)) return -1;
        return arr[ptrs[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum){
        return ptrs[stackNum] == stackSize * stackNum;
    }


        public class Main {
    public static void main(String[] args) {
    int stackSize = 3;
    TripleInOne tripleInOne = new TripleInOne(stackSize);
       // 向栈1中添加元素
      tripleInOne.push(0, 1);
      tripleInOne.push(0, 2);
      tripleInOne.push(0, 3);

      // 向栈2中添加元素
      tripleInOne.push(1, 4);
      tripleInOne.push(1, 5);
      tripleInOne.push(1, 6);

      // 向栈3中添加元素
      tripleInOne.push(2, 7);
      tripleInOne.push(2, 8);
      tripleInOne.push(2, 9);

      // 从栈1中弹出一个元素
      System.out.println(tripleInOne.pop(0)); // 输出 3

      // 获取栈2的栈顶元素
      System.out.println(tripleInOne.peek(1)); // 输出 6

      // 检查栈3是否为空
      System.out.println(tripleInOne.isEmpty(2)); // 输出 false
  }

  


}