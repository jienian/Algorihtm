//这一段代码是一个解决最大问题的算法。它使用了动态计划的想法。
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for(int x : nums){
            pre = Math. max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
    return maxAns;
    }
}