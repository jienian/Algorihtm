//Google-PayPal女工程师第四轮笔试
public class WaveSubsequences {

    public static int countWaveSubsequences(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        int[] up = new int[n];   
        int[] down = new int[n]; 
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i-2] < nums[i-1] && nums[i-1] > nums[i]) {
                up[i] = down[i-1] + 1;
                down[i] = 0;
            } else if (nums[i-2] > nums[i-1] && nums[i-1] < nums[i]) {
                down[i] = up[i-1] + 1;
                up[i] = 0;
            } else {
                up[i] = 0;
                down[i] = 0;
            }

            count += Math.max(up[i], down[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a1 = {3, 1, 4, 2, 5};
        System.out.println(countWaveSubsequences(a1));  

        int[] a2 = {1, 2, 3, 4, 5};
        System.out.println(countWaveSubsequences(a2));  

        int[] a3 = {1, 1, 2, 1};
        System.out.println(countWaveSubsequences(a3));  
    }
}
