import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
    if(intervals.length == 0 ){
        return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> list = new Arrays<>();
        int term[] =intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(term[1]>=intervals[i][0]){
                term[1]=Math.max(term[1],intervals[i][1]);
            }else{
                list.add(term);
                term=intervals[i];
            }
        }
        list.add(term);
        return list.toArray(new int[list.size()][2]);
    }

}