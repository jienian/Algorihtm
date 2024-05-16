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


class Solution {
    public int[] findSquare(int[][] matrix) {
        // dp[i][j][0]表示,i,j左边连续的0的个数
        // dp[i][j][1]表示,i,j上边连续的0的个数
        int n = matrix.length;
        int[][][] dp = new int[n][n][2];
        int r = -1, c = -1; //左上角的行、列序号
        int side = 0; // 保存最大黑方的边长
        for(int i = 0; i < n; i++){ 
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    dp[i][j][0] = 1 + (j > 0 ? dp[i][j-1][0] : 0);
                    dp[i][j][1] = 1 + (i > 0 ? dp[i-1][j][1] : 0);
                }
                for(int size = Math.min(dp[i][j][0], dp[i][j][1]); size >= 1; size--){
                    // 针对[i][j]，获取左侧和上侧连续黑色区域的长度的最小值，因为要保证正方形
                    if(dp[i][j-size+1][1] >= size && dp[i-size+1][j][0] >= size){
                        // 要确定4条边，那么对应的上侧就是[i-size+1][j]0]
                        // 对应的左侧边就是[i][j-size+1][1]
                        // 如果这二者满足>=size则可以构成正方形
                        if(size > side){
                            side = size;
                            r = i - size + 1;
                            c = j - size + 1;
                            break;
                        }
                    }
                }
            }
        }
        if(r == -1 && c == -1) return new int[0];
        return new int[]{r, c, side};

    }
}

//面试题08.10. 颜色填充
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 队列
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        // 方向数组
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[0];
            int j = arr[1];
            int oldColor = image[i][j];
            image[i][j] = newColor;
            for (int k = 0; k < dir.length; k++) {
                int r = dir[k][0] + i;
                int c = dir[k][1] + j;
                if (r >= 0 && r < image.length && c >=0 && c < image[0].length && image[r][c] == oldColor && image[r][c] != newColor) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        return image;
    }
}

//国王与金矿
public int getMostGold(int totalWork, int[] p, int[] g) {
	int[][] dp = new int[totalWorker + 1][p.length];
	for(int = 1; i <= totalWorker; i++) {
		if(i >= p[0]) dp[i][0] = g[0];
	}
	for (int i = 1; i <= totalWorker; i++) {	
		for(int j = 1; j < p.length; j++) {
			if(i  < p[j])
				dp[i][j]  = dp[i][j - 1];
			else 
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - p[j]][j - 1] + g[j]);
			
		}
	}
	return dp[totalWorker][p.length - 1];
  
}
