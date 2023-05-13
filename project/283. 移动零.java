class Main{
    public void moveZeries(int[] nums){
        int n = nums.length;
        int left = 0, right = 0;
        while(right < n){
            if(nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args){
        Main solution = new Main();
        int[] nums = {0, 1, 0, 4, 12,22, 0};
        solution.moveZeries(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length; // 数组长度
        int left = 0; // 左指针，表示下一个非零元素要移动到的位置
        int right = 0; // 右指针，用于遍历数组

        // 双指针遍历数组
        while (right < n) {
            if (nums[right] != 0) {
                // 如果右指针指向的元素不为零，则将其移动到左指针指向的位置
                swap(nums, left, right);
                left++; // 左指针向右移动
            }
            right++; // 右指针向右移动
        }
    }

    public void swap(int[] nums, int left, int right) {
        // 交换数组中指定索引位置的元素
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
O(n)
O(1)