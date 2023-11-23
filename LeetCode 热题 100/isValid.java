class Solution{
    public boolean isValid(String s){
        if(s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(char c :s.toCharArray()){
            if(c =='(' || c =='[' || c== '{'){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(c ==')' && top != '(' || c == ']' && top != '[' || c =='}' && top != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}