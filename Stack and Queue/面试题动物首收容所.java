class AnimalShelf {
    LinkedList<int[]> queueCat;
    LinkedList<int[]> queueDog;
    public AnimalShelf() {
        queueCat = new LinkedList<>();
        queueDog = new LinkedList<>();
    }
    
    public void enqueue(int[] animal) {
        if(animal[1] == 0){
            queueCat.addLast(animal);
        }else if(animal[1] == 1){
            queueDog.addLast(animal);
        }
    }
    
    public int[] dequeueAny() {
        int[] headCat;
        if(!queueCat.isEmpty()){
            headCat = queueCat.getFirst();
        }else if(!queueDog.isEmpty()){
            return queueDog.removeFirst();
        }else{
            return new int[] {-1, -1};
        }
        int[] headDog;
        if(!queueDog.isEmpty()){
            headDog = queueDog.getFirst();
        }else{
            return queueCat.removeFirst();
        }
        if(headCat[0] <= headDog[0]){
            return queueCat.removeFirst();
        }else{
            return queueDog.removeFirst();
        }
    }
    
    public int[] dequeueDog() {
        if(!queueDog.isEmpty()){
            return queueDog.removeFirst();
        }else{
            return new int[] {-1, -1};
        }
    }
    
    public int[] dequeueCat() {
        if(!queueCat.isEmpty()){
            return queueCat.removeFirst();
        }else{
            return new int[]{-1, -1};
        }
    }
}