class Solution {
    public int findString(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;

        while(left <= right){
            while(left < right && words[left].isEmpty()){
                left++;
            }
            while(left < right && words[right].isEmpty()){
                right--;
            }
            int mid = left + (right - left) / 2;

            while(mid < right && words[mid].isEmpty()){
                mid++;
            }
            if(words[mid].equals(s)){
                return mid;
            }else if(words[mid].compareTo(s) < 0){
                left = mid + 1;

            }else{
                right = mid - 1;
            }
        }
        return - 1;
    }
}