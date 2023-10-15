import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        for (int i = 0; i < numRows ; i++) {
            List<Integer> bs = new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                 if(j == 0 || j == i ) bs.add(1);
                else{
                    bs.add(abs.get(i-1).get(j-1)+abs.get(i-1).get(j));
                                }
            }
            abs.add(bs);
        }
        return abs;
    }
}