class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        // 二分查找
        // 最短字符串的字符数 minLength
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
            minLength = Math.min(minLength, strs[i].length());
        }
        // 在 0 - minLength 区间内进行二分查找
        int start = 0, end = minLength;
        while(start < end){
            int mid = (end - start + 1) / 2 + start;
            if(isPrefix(strs, mid)){
                start = mid;
            }else{
                end = mid - 1;
            }
        }
        return strs[0].substring(0, start);
    }

    public boolean isPrefix(String[] strs, int length){
        String str0 = strs[0].substring(0, length);
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            for(int j = 0; j < length; j++){
                if(str0.charAt(j) != str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
