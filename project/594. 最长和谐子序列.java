class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        
        int begin = 0;
        int res = 0;
        for(int end = 0; end < nums.length; end++){
            if(nums[end] - nums[begin] > 1){
                begin++;
            }
            if(nums[end] - nums[begin] == 1){
                res =  Math.max(res, end - begin + 1);
            }
        }
        return res;
    }
}
