class Solution {
    public boolean isIsomorphic(String s, String t) {
        // 用两个map来存储两个字符串中对应字符的映射关系
        Map<Character, Character> s1 = new HashMap<Character, Character>();
        Map<Character, Character> t2 = new HashMap<Character, Character>();
        int len = s.length();
        for(int i = 0; i < len; ++i){
            char x = s.charAt(i), y = t.charAt(i);
            // 如果映射关系不一致，则不是同构字符串
            if((s1.containsKey(x) && s1.get(x) != y) || (t2.containsKey(y)  && t2.get(y) != x  )) {
                return false;
            }   
            // 建立映射关系
            s1.put(x, y);
            t2.put(y, x);
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "egg", t1 = "add";
        String s2 = "foo", t2 = "bar";
        String s3 = "paper", t3 = "title";
        System.out.println(solution.isIsomorphic(s1, t1)); // true
        System.out.println(solution.isIsomorphic(s2, t2)); // false
        System.out.println(solution.isIsomorphic(s3, t3)); // true
    }
}
