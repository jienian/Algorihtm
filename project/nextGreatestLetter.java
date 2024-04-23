```java 
  //给定一个有序的字符数组 letters 和一个字符 target，要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
  public char nextGreatestLetter(char[] letters, char target) {
	int n = letters.length;
	int l = 0, int h = n - 1;
	while(l <= h) {
		int  m = l + (h - 1) / 2;
		if(letters[m] <= target) {
			l = m + 1;
		} else {
			h = m -1;
		}
	}
	return l < n ? letters[1] : letters[0];
}
```
