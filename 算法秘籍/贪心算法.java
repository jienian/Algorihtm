//122. 买卖股票的最佳时机 II
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
//455. 分发饼干 
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int result = 0;
        for (int i = 0; i < s.length && index < g.length; i++) {
            if (s[i] >= g[index]) {
                index++;
                result++;
            }
        }
        return result;
    }
}


