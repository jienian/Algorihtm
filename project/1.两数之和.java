class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0;i < n;++i){
            for(int j = i + 1;j < n;++j){
                if(nums[i] + nums[j] ==target) return new int[]{i , j};
                            }
        }
        return new int[0];
    }
}
public class Test{
public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] result = solution.twoSum(nums, target);
    System.out.println(Arrays.toString(result)); // 输出 [0, 1]
    }
}