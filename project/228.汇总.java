class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        for(int j = 0; j < nums.length;j++){
            if(j + 1 == nums.length || nums[j] + 1 != nums[j + 1]){
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if(i != j){
                    sb.append("->").append(nums[j]);
                }
                res.add(sb.toString());
                i = j + 1;
            }
        }
        return res;
    }
}