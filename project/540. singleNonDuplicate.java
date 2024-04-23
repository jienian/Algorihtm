```java
  //题目描述：一个有序数组只有一个数不出现两次，找出这个数。
  /* Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
  Output: 2 */
  public int singleNonDuplicate(int[] nums) {
	int l = 0, h = nums.length - 1;
	while(l < h) {
		int m = l + (h - 1) / 2;
		if ( m % 2 == 1) {
			m --;
		}
		if (nums[m] == nums[m + 1] ) {
			h = m;
		}
	}
	return nums[l];
}
  ```
