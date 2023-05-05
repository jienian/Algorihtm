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
//