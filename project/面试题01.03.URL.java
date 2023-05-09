public class Solution {
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        
        int newLength = length + 2 * spaceCount;
        int newIndex = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[newIndex--] = '0';
                chars[newIndex--] = '2';
                chars[newIndex--] = '%';
            } else {
                chars[newIndex--] = chars[i];
            }
        }
        
        return new String(chars, 0, newLength);
    }
}
