public void heapSort(int[] nums) {
  MyHeap<Integer> myHeap = new Myheap(10);
  for(int i = 0; i < nums.length; i++) {
    myHeap.add(nums[i]);
    int index = 0;
    while(index < nums.length) {
      nums[index++] = myHeap.remove();
    }
  }
}
