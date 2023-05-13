class Main {
    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }


    public void Main(String[] args){
        int[] nums = {1, 2, 3, 1};
        Main solution = new Main();
        int peakIndex = solution.findPeakElement(nums);
        System.out.println("peak element index" + peakIndex);
        System.out.pritnln("peak element value" + nums[peakIndex]);
    }
}

