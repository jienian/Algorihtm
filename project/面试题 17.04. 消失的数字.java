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

import java.util.Arrays;
class Main {
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
    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 4, 5}; 

        Main solution = new Main();
        int missingNumber = solution.missingNumber(nums);
        System.out.println("missing: " + missingNumber);
    }

}
