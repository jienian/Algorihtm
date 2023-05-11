双指针
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 从右向左找到第一个非递增的元素
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            // 从右向左找到第一个比 nums[i] 大的元素
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }

        // 反转 i+1 后面的元素，使其变为升序
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3};
        System.out.print("Original Array: ");
        printArray(nums1);
        solution.nextPermutation(nums1);
        System.out.print("Next Permutation: ");
        printArray(nums1);
        System.out.println();

        int[] nums2 = {3, 2, 1};
        System.out.print("Original Array: ");
        printArray(nums2);
        solution.nextPermutation(nums2);
        System.out.print("Next Permutation: ");
        printArray(nums2);
        System.out.println();

        int[] nums3 = {1, 1, 5};
        System.out.print("Original Array: ");
        printArray(nums3);
        solution.nextPermutation(nums3);
        System.out.print("Next Permutation: ");
        printArray(nums3);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
结果：
Original Array: 1 2 3
Next Permutation: 1 3 2

Original Array: 3 2 1
Next Permutation: 1 2 3

Original Array: 1 1 5
Next Permutation: 1 5 1

O(n) O(1)