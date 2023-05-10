class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;  // 初始化候选数为-1
        int count = 0;  // 初始化候选数的计数为0
        for (int num : nums) {  // 遍历输入数组中的所有数
            if (count == 0) {  // 如果候选数的计数为0，则更新候选数为当前数
                candidate = num;
            }
            if (num == candidate) {  // 如果当前数与候选数相同，则将候选数的计数加1
                count++;
            } else {  // 如果当前数与候选数不同，则将候选数的计数减1
                count--;
            }
        }
        count = 0;  // 重新初始化候选数的计数
        int length = nums.length;  // 获取输入数组的长度
        for (int num : nums) {  // 再次遍历输入数组中的所有数
            if (num == candidate) {  // 如果当前数与候选数相同，则将候选数的计数加1
                count++;
            }
        }
        return count * 2 > length ? candidate : -1;  // 判断候选数是否为众数，是则返回候选数，否则返回-1
    }
}
