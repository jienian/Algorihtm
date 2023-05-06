//斐波那契数列 O(n2)
int fibonacci(int i){
    if(i == 0) return 0;
    if(i == 1) return 1;
    return fibonacci(i - 1) + fibonacci(i - 2);
}

//记忆法优化后： 自上而下O(n)
int fibonacci(int i){
    return fibonacci(n, new int[n + 1]);
int fibonacci(int i, int[] memo){
    if(i == 0 || i == 1) return i;
    if(memo[i] == 0){
        memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
    }
    return memo[i];
    }
}

//动自上而下动态规划
int fibonacci(int n){
    if(n == 0) return 0;
    else if(n == 1) return 1;
    int[] memo = new int[n];
    memo[0] = 0;
    memo[1] = 1;
    for(int i = 2; i < n; i++){
        memo[i] = memo[i - 1]+ memo[i - 2];
    }
    return memo[n - 1] + memo[n - 2];
}

//三步问题
class Solution {
    public int waysToStep(int n) {
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        if(n < 4) return dp[ n - 1];
        for(int i = 0; i < n - 3;i++){
            dp[i % 3] = (dp[0] + (dp[1] + dp[2]) % 1000000007) %1000000007;
        }
        return dp[(n - 4) % 3];
    }
}
//魔术索引

public int findMagicIndex(int[] nums){
    for(int i = 0; i < nums.length; i++){
        if(i == nums[i]) return i;

    }
    return -1;
}

//幂集
class Solution{
    public List<List<Integer>> result = new ArrayList<>(); // 用于存储最终结果的列表
    public List<List<Integer>> subsets(int[] nums){
        dfs(nums, 0, new ArrayList<>()); // 调用深度优先搜索函数，传入数组、起始索引和空的中间结果列表
        return result; // 返回最终结果
    }
    
    public void dfs(int[] nums, int start, List<Integer> arr){
        result.add(new ArrayList<>(arr)); // 将当前中间结果列表添加到最终结果列表中
        for(int i = start; i < nums.length;++i){ // 从起始索引开始遍历数组
            arr.add(nums[i]); // 将当前元素添加到中间结果列表中
            dfs(nums, i + 1, arr); // 递归调用自身，继续向后遍历数组
            arr.remove(arr.size() - 1); // 回溯，移除最后一个添加的元素，以便尝试其他可能性
        }
    }
    //测试main
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}


