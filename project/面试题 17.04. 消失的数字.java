class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for(int i = 0; i < n;i++){
            set.add(nums[i]);
        }
        int missing = -1;
        for(int i = 0; i <= n;i++){
            if(!set.contains(i)){
                missing = i;
                break;
            }
        }
        return missing;
    }
}
//排序
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i =0; i < n; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return n;
    }
}
