import java.util.HashSet;
import java.util.Set;

/*哈希表
 * O(n), O(n)
 *  找出定定数数组中最长连续序列的长度
 * 
 */
class Solution {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for(int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for(int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currenNum = num;
                int currentStreak = 1;
                while (num_set.contains(currenNum + 1)) {
                    currenNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }



    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longestStreak = longestConsecutive(nums);
        System.out.println("The longest ...");
    }
}