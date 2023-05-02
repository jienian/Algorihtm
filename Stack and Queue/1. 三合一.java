class TripleInOne{
    private int[] arr;
    private int[] ptrs;
    private stackSize;

    public TripleInOne(int stackSize){
        this.stackSize = stackSize;
        arr = new int[3 * stackSize];

        ptrs = new int[3];
        ptrs[0] = 0;
        ptrs[1] = stackSize;
        ptrs[2] = stackSize * 2;
    }

            
}