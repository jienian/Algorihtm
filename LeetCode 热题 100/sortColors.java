/*
 * @75.颜色分类
 * 进行颜色数组进行排序
 * 双指针
 * O(n), O(1)
*/

class Solution {
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        //遍历颜色数组
        for (int i = 0; i < n; ++i) {
            // 如果当前颜色为1，则与颜色数组中第一个为0的元素交换位置，并更新p1的值
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            // 如果当前颜色为0，则与颜色数组中第一个为0的元素交换位置    
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
            // 如果p0 < p1，则将当前颜色0与颜色数组中第一个为1的元素交换位置    
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for(int num : nums) {
            System.out.println(num + " ");
        }
    }

}
