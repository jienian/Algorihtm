class Solution{
    public String[] permutation(String S){
        HashSet<String> set = new HashSet<String>();
        dfs(new StringBuffer(), new StringBuffer(S), set);
        return new String[set.size()];
    }
    public void dfs(StringBuffer sb, StringBuffer rest, HashSet<String> set){
        if(rest.length() == 0){
            set.add(sb.toString());
        }else{
            for(int i =0; i <= rest.length() - 1;i++){
                StringBuffer sbNext = new StringBuffer(sb);
                sbNext.append(rest.charAt(i));
                StringBuffer restNext = new StringBuffer(rest.substring(0, i) + rest.substring(i + 1));
                dfs(sbNext, restNext, set);
            }
        }
    }
}