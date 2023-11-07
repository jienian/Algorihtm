//O(n)
//O(1)
class Solution {
    public static int singleNumber(int[] nums) {
        int single = 0;
        for(int num : nums) {
            single ^= num; // 使用异或运算符对每个元素进行异或操作
        }
        return single;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 3};
        int result = singleNumber(nums);
        System.out.println(result);
    }

}