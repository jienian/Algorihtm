class Solution{
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length;i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if(sum > target) end--;
                else if (sum < target) start++;
                else return ans;
                
            }
        }
        return ans;
    }
}

//注释版
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 对数组进行排序，以便于使用双指针法
        Arrays.sort(nums);
        
        // 初始化结果变量为前三个数的和
        int ans = nums[0] + nums[1] + nums[2];
        
        // 遍历数组，作为第一个数
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1; // 左指针指向当前数的下一个数
            int end = nums.length - 1; // 右指针指向数组末尾
            
            // 使用双指针法查找最接近目标值的三个数的和
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                
                // 更新结果变量，如果当前和更接近目标值
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                
                // 根据当前和与目标值的大小关系移动指针
                if (sum > target)
                    end--; // 和过大，右指针左移
                else if (sum < target)
                    start++; // 和过小，左指针右移
                else
                    return ans; // 和等于目标值，直接返回结果
            }
        }
        
        // 遍历完成后返回最接近目标值的三个数的和
        return ans;
    }
}
