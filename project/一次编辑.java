class Solution {
    public boolean oneEditAway(String first, String second) {
        int M = first.length();
        int N = second.length();
        if(M > N + 1 || N > M + 1)return false;
        if(N == M + 1){return oneEditAway(second, first);}
        int i = 0, j = 0;
        int diff = 0;
        while(i < M && j < N){
            if(first.charAt(i) != second.charAt(j)){
                diff++;
                if(diff >= 2) return false;
                if(M > N){
                    j--;
                }
              }
                i++;
                j++;
            }
            return true;
        
    }
}