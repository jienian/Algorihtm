public class Main {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("原数组:");
        printArray(nums);

        moveZeroes(nums);

        System.out.println("\n移动零元素后的数组:");
        printArray(nums);
    }

    // 用于打印数组
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //logic
    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
