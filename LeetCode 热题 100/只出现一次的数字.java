//O(n)
//O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num : nums) {
            single ^= num;
        }
        return single;
    }
}