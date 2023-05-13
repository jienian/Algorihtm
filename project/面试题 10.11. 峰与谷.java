import java.util.Arrays;

class Main {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums); // 对数组进行排序

        for (int i = 1; i < nums.length - 1; i += 2) {
            // 将相邻的元素交换位置
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 1, 2, 3};
        Main solution = new Main();
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
