class Main {
    public int search(int[] nums, int target) {
        int n = nums.length; // 数组的长度
        if (n == 0) { // 数组为空，返回 -1
            return -1;
        }
        if (n == 1) { // 数组只有一个元素
            return nums[0] == target ? 0 : -1; // 如果该元素等于目标值，则返回索引0，否则返回 -1
        }
        int l = 0, r = n - 1; // 初始化左右边界指针
        while (l <= r) { // 使用二分查找法进行搜索
            int mid = (l + r) / 2; // 计算中间元素的索引
            if (nums[mid] == target) { // 中间元素等于目标值，找到目标值，返回索引 mid
                return mid;
            }
            if (nums[0] <= nums[mid]) { // 左半部分是有序的
                if (nums[0] <= target && target < nums[mid]) { // 目标值在左半部分有序区间内
                    r = mid - 1; // 在左半部分继续搜索
                } else {
                    l = mid + 1; // 在右半部分继续搜索
                }
            } else { // 右半部分是有序的
                if (nums[mid] < target && target <= nums[n - 1]) { // 目标值在右半部分有序区间内
                    l = mid + 1; // 在右半部分继续搜索
                } else {
                    r = mid - 1; // 在左半部分继续搜索
                }
            }
        }
        return -1; // 没有找到目标值，返回 -1
    }
    public static void main(String[] args) {
        Main solution = new Main();

        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = solution.search(nums, target);

        System.out.println("目标值的索引为: " + result);
    }
}
O(n^2)
O(1)