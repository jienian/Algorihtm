
//16.24 数对和。设计一个算法，找出数组中两数之和为指定值的所有整数对。 
//暴力枚举算法
public ArrayList<Pair> printPairSums(int[] array, int sum) {
	ArrayList<Pair> result = new ArrayList<Pair>();
	for(int i = 0; i < array.length; i++) {
		for(int j = i + 1; j < array.length; j++) {
			if(array[i] + array[j] == sum) {
				result.add(new Pair(array[i], array[j]));
			}
		}
	}
	return result;
}

//第二种方法哈希表实现,O(n),O(n)
public List<Pair> findPairsWithSum(int[] array, int sum) {
    List<Pair> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < array.length; i++) {
        int complement = sum - array[i];
        if (map.containsKey(complement)) {
            // 如果找到了complement，则说明找到了一对数，将它们作为Pair加入结果列表
            result.add(new Pair(complement, array[i]));
        }
    
        map.put(array[i], i);
    }
    
    return result;
}
class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
