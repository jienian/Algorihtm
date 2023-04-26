//303. 区域和检索 - 数组不可变
class NumArray {
    int[] sums; // 定义数组 sums 存储前缀和

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1]; // 初始化 sums 数组，长度比 nums 多一位
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i]; // 计算前缀和，存储到 sums 数组中
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i]; // 计算区间和，返回结果
    }
}

public class Test {
    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2)); // 输出 1
        System.out.println(obj.sumRange(2, 5)); // 输出 -1
        System.out.println(obj.sumRange(0, 5)); // 输出 -3
    }
}



