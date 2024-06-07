//16.21 交换和。给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。 
//采用暴力法
public int findSwapValues(int[] array1, int[] array2){
	int sum1 = sum(array1);
	int sum2 = sum(array2);
	for(int one : array1) {
		for(int two : array2) {
			int newSum1 = sum1 - one + two;
			int newSum2  = sum2 - two + one;
			if(newSum1 == newSum2) {
			int[] values = {one, two};
			return values;		
			}
		}
	}
}