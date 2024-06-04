//剑指 Offer 39. 数组中出现次数超过一半的数字
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}

//假若由于题目说明，给定的数组总是存在多数元素，需要加入一个 “验证环节” ，遍历数组 nums 统计 x 的数量。
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
         // 验证 x 是否为众数
         for(int num : nums)
         if(num == x) count++;
         return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
        }
    }
}