class AnimalShelf {
    LinkedList<int[]> queueCat; // 用于存储猫的队列，每个元素是一个长度为2的数组，存储动物的编号和种类
    LinkedList<int[]> queueDog; // 用于存储狗的队列，每个元素是一个长度为2的数组，存储动物的编号和种类

    public AnimalShelf() {
        queueCat = new LinkedList<>();
        queueDog = new LinkedList<>();
    }
    
    public void enqueue(int[] animal) {
        // 判断种类后入队
        if(animal[1] == 0){ // 如果是猫的话
            queueCat.addLast(animal); // 将猫加入猫队列的末尾
        }else if(animal[1] == 1){ // 如果是狗的话
            queueDog.addLast(animal); // 将狗加入狗队列的末尾
        }
    }
    
    // 挑选出最老的动物（猫或狗）
    public int[] dequeueAny() {
        int[] headCat;
        // 取出cat的队首，判空则直接返回
        if(!queueCat.isEmpty()){
            headCat = queueCat.getFirst(); // 获取猫队列的头部元素
        }else if(!queueDog.isEmpty()){
            // 当猫队列无猫时，直接将狗队列的第一个出队
            return queueDog.removeFirst(); // 返回狗队列的头部元素并将其移除
        }else{
            return new int[] {-1, -1}; // 都为空则返回无效值
        }
        
        int[] headDog;
        if(!queueDog.isEmpty()){
            headDog = queueDog.getFirst(); // 获取狗队列的头部元素
        }else{
            return queueCat.removeFirst(); // 返回猫队列的头部元素并将其移除
        }
        
        if(headCat[0] <= headDog[0]){ // 比较猫和狗队列的首个动物编号，选择最老的动物
            return queueCat.removeFirst(); // 返回猫队列的头部元素并将其移除
        }else{
            return queueDog.removeFirst(); // 返回狗队列的头部元素并将其移除
        }
    }
    
    public int[] dequeueDog() {
        if(!queueDog.isEmpty()){
            return queueDog.removeFirst(); // 返回狗队列的头部元素并将其移除
        }else{
            return new int[] {-1, -1}; // 队列为空则返回无效值
        }
    }
    
    public int[] dequeueCat() {
        if(!queueCat.isEmpty()){
            return queueCat.removeFirst(); // 返回猫队列的头部元素并将其移除
        }else{
            return new int[]{-1, -1}; // 队列为空则返回无效值
        }
    }
}
