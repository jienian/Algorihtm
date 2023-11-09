class Solution {
    //接受一个整数数组和一个整数k作为参数。首先，k对数组长度取模，然后将数组中的元素向右移动k个位置，最后返回数组。
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    //通过传入一个征信数组和起始位置和结束为止，将数组中起始位置到结束位置之间的元素进行反转。
    public void reverse(int[] nums, int start, int end ) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}