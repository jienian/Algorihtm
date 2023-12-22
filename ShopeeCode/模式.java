import java.util.Stack;

public class Solution {
    /**
     * 判断数组中是否存在132模式
     *
     *  nums 给定的整数数组
     *  如果存在132模式，则返回true；否则，返回false。
     */
    public boolean find132pattern(int[] nums) {
        int N = nums.length;
        int[] minValues = new int[N];
        minValues[0] = nums[0];

        // 计算每个位置的最小值
        for (int i = 1; i < N; i++) {
            minValues[i] = Math.min(minValues[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        // 从右往左遍历，查找132模式
        for (int j = N - 1; j >= 0; j--) {
            if (nums[j] > minValues[j]) {
                // 找到了元素2，查找元素3
                while (!stack.isEmpty() && stack.peek() <= minValues[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4}; // 示例数组

        Solution solution = new Solution();
        boolean hasPattern = solution.find132pattern(nums);
        System.out.println("是否存在132模式: " + hasPattern);
    }
}
