#### 

# 练习

```java
//O(1)
void swapTwoInts(int a, int b){
  int temp =a;
  a = b;
  b = temp;
}
//O(n)
int sum (int n) {
  for(int i = 0; i < n; i++){
    ret += i;
  }
  return ret;
}
// c * O(n) 中的 c 可能小于 1 
void reverse(string a){
  int n = s.size();
  for(int i = 0 ; i < n/2 ; i++){
    swap(s[i]  ,s[n-1-i]);
  }
}
//O(n2)
void selectionSort(int arr[],int n){
  for(int i = 0 ; i < n ; i++){
    int minIndex = i;
    for(int j = i + 1 ; j < n; j++){
      if(arr[j] <arr[minIndex])
        minIndex = j;
      
      swap(arr[i] ,arr[minIndex]);
    } 
}
//O(logn)
  int binarySearch(int arr[], int n ,int target){
    int l = 0 ; r = n - 1;
    while(l <= r){
      int mid = l + (r - l)/2;
      if(arr[mid] == target){
        return mid;
      }
      if(arr[mid] > target){
       r = mid - 1;
      }
    }else l = mid + 1;
  }
  return -1;
}
//O(nlogn)
void hello(){
  for(m = 1 ;m < n; m++){
    i = 1;
    while(i < n){
      i = i * 2;
    }
  }
}
```

# 初级数据结构

## 数组、字符串（Array&String）

优点：1.构建一个数组简单2.能让我们在O(1)的时间里根据数组的下标（Index）查询某个元素

缺点：1.构建时必须分配一段连续的空间2.查询某个元素是否存在时需要遍历整个数组，耗费O(n)的时间(n是元素的个数)

3.删除和添加某个元素时，同样需要耗费0(n)的时间

### 242.有效的字母异位词

排序

```java

```

哈希表优化

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        // 如果字符串s和字符串t的长度不相等，返回false
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26]; // 创建一个长度为26的数组
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++; // 将每个字符出现的次数保存在数组table中
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--; // 将table中每个字符的计数减1
            if (table[t.charAt(i) - 'a'] < 0) { // 如果table中这个字符的计数变为负数，说明字符串t包含一个字符串s中不存在的字符，返回false
                return false;
            }
        }
        // 检查table中所有计数是否都为0，如果是，则这两个字符串是字母异位词
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

O(n)
O(1)

```



## 链表（LinkedList）

单链表

优点：1.灵活地分配内存空间2.能在O(1)时间内删除或者添加元素

缺点：查询元素需要O(n)时间     list.next.next

解题技巧：1.利用快慢指针（有时候需要用到三个指针）如:prev curr next  2.构建一个虚假的链表头

例如 1.两个排序链表，进行整合排序 2.将链表的奇偶数按原定顺序分离，生成前半部分为奇数，后半部分为偶数的链表

### 25.K个一组翻转链表

```java

```

## 栈（Stack）

特点：LIFO 后进先出

算法基本思想：1.可以用一个单链表来实现2.只关心上一次的操作3.处理完上一次的操作后，能在O(1)时间内查找到更前一次的操作

### 20.有效的括号

```java
class Solution {
public boolean isValid(String s) {
    if (s == null || s.length() == 0) {  // 判断字符串为空或长度为0，直接返回true
        return true;
    }
    Stack<Character> stack = new Stack<>(); // 创建一个字符类型的栈
    for (char c : s.toCharArray()) { // 遍历字符串s的每个字符
        if (c == '(' || c == '[' || c == '{') { // 如果是左括号，则将其压入栈中
            stack.push(c);
        } else { // 如果是右括号，则弹出栈顶元素并判断是否匹配
            if (stack.isEmpty()) { // 如果栈为空，则说明缺少左括号，直接返回false
                return false;
            }
            char top = stack.pop(); // 弹出栈顶元素
            if (c == ')' && top != '(' || c == ']' && top != '[' || c == '}' && top != '{') { // 判断栈顶元素是否与当前右括号匹配
                return false; // 如果不匹配，返回false
            }
        }
    }
    return stack.isEmpty(); // 最后判断栈是否为空，如果为空说明匹配成功，返回true，否则返回false
}
}
```

### 739.每日温度

```java
class Solution{
  
    // 存储每个元素的结果
    int[] res = new int[T.length];
    // 栈存储元素下标
    Stack<Integer> stack  = new Stack<>();
    
    for(int i = 0; i < T.length;i++){
       // 如果栈顶元素比当前元素小
       while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
         //出栈
        int prev = stack.pop(); 
          // 更新结果数组
         res[prev] = i - prev;
      }
      // 将当前元素下标入栈
      stack.push(i);
    }
    //返回结果数组
    return res;
  }
}
```

## 队列（Queue）

特点：FIFO先进先出

常用场景：广度优先搜索

## 双端队列（Deque）

基本 实现：1.可以利用一个双链表 2.队列的头尾两端能在O(1)的时间内进行数据的查看、添加和删除

常用场景：实现一个长度动态比爱话的窗口或者连续区间

### 239.滑动窗口最大值

```java

```

## 树（Tree）

树的共性：1.结构直观2.通过树问题来考察递归算法掌握的熟练程度

面试中常考的树的形状有：1.普通叉树2.平衡二叉树3.完全二叉树4.二叉搜索树5.四叉树6.多叉树7.特殊的树：红黑树、自平衡二叉搜索树树



遍历 ：1.前序遍历（Preorder Traversal）2.中序遍历（Inorder Traversal）3.后序遍历（Postorder Traversal）

### 230.二叉搜索中第K小的元素

```java
class Solution{
  public int kthSmallest(TreeNode root, int k){
    //创建一个栈，用于迭代遍历树的节点
    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    //当根节点不为空或栈不为空时循环
    while(root != null || stack,isEmpty()){
      while(root != null){
        //将根节点的所有左子树节点都压入栈中
        stack.push(root);
        root = root.left;
      }
      //弹出一个节点
      root = stack.pop();
      //计数器减1
      --k;
      //如果k已经为0，说明了已经访问了K个节点，返回当前节点的值
      if(k == 0){
        break;
      }
      //继续遍历右子树
      root = root.right;
    }
    //返回第k小的节点的值
    return root.val;
  }
}
O(h+k)
O(h)
```

# 高级数据结构

## 优先队列Priority Queue

与普通队列：1.保证每次取出的元素时队列中优先级最高的2.优先级可自定义

常用场景：从杂乱无章的数据中按照一定的顺序（或者优先级）筛选数据

本质：1.二叉树的结构，堆在英文叫BinaryHeap2.利用一个数组结构来实现完全二叉树

其基本操作为一下两个

向上筛选（Sift up/Bubble up）

向下筛选（sit down / bubble down）

### 347.前K个高频元素

```java

```

## 图Graph

图绕图的算法也是各式各样，（必须熟练掌握）以下

**图的遍历：深度优先、广度优先**

环的检测：有向图、无向图

**图的存储和表达方式：邻接矩阵、邻接链表**

扩扑排序

联合-查找算法（Union-Find）

最短路径算法：Dijkstra、Bellman-Ford、FloydWarshall

连通性相关算法：Kosaraju、Tarjan、求解孤岛的数量、判断是否为树

图的着色、旅行商问题等

基础代码：

```java
/* 基于邻接矩阵实现的无向图类 */
class GraphAdjMat {
    List<Integer> vertices; // 顶点列表，元素代表“顶点值”，索引代表“顶点索引”
    List<List<Integer>> adjMat; // 邻接矩阵，行列索引对应“顶点索引”

    /* 构造方法 */
    public GraphAdjMat(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjMat = new ArrayList<>();
        // 添加顶点
        for (int val : vertices) {
            addVertex(val);
        }
        // 添加边
        // 请注意，edges 元素代表顶点索引，即对应 vertices 元素索引
        for (int[] e : edges) {
            addEdge(e[0], e[1]);
        }
    }

    /* 获取顶点数量 */
    public int size() {
        return vertices.size();
    }

    /* 添加顶点 */
    public void addVertex(int val) {
        int n = size();
        // 向顶点列表中添加新顶点的值
        vertices.add(val);
        // 在邻接矩阵中添加一行
        List<Integer> newRow = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            newRow.add(0);
        }
        adjMat.add(newRow);
        // 在邻接矩阵中添加一列
        for (List<Integer> row : adjMat) {
            row.add(0);
        }
    }

    /* 删除顶点 */
    public void removeVertex(int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        // 在顶点列表中移除索引 index 的顶点
        vertices.remove(index);
        // 在邻接矩阵中删除索引 index 的行
        adjMat.remove(index);
        // 在邻接矩阵中删除索引 index 的列
        for (List<Integer> row : adjMat) {
            row.remove(index);
        }
    }

    /* 添加边 */
    // 参数 i, j 对应 vertices 元素索引
    public void addEdge(int i, int j) {
        // 索引越界与相等处理
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j)
            throw new IndexOutOfBoundsException();
        // 在无向图中，邻接矩阵沿主对角线对称，即满足 (i, j) == (j, i)
        adjMat.get(i).set(j, 1);
        adjMat.get(j).set(i, 1);
    }

    /* 删除边 */
    // 参数 i, j 对应 vertices 元素索引
    public void removeEdge(int i, int j) {
        // 索引越界与相等处理
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j)
            throw new IndexOutOfBoundsException();
        adjMat.get(i).set(j, 0);
        adjMat.get(j).set(i, 0);
    }

    /* 打印邻接矩阵 */
    public void print() {
        System.out.print("顶点列表 = ");
        System.out.println(vertices);
        System.out.println("邻接矩阵 =");
        PrintUtil.printMatrix(adjMat);
    }
}

```



### 785.判断二分图

```java

```



## 前缀树Trie

也称为字典树：这种数据结构被广泛地运用在字典查找当中

什么是字典查找？

例如：给定一系列构成字典的字符串，要求在字典当中找出所有以“ABC”开头的字符串

方法一：暴力搜索法 时间复杂度：O(M*N)

方法二：前缀树 时间复杂度：O(M

经典应用：搜索框输入搜索文字，会罗列以搜索词开头的相关搜索

重要性质：每个节点至少包含两个基本属性

children：数组或者集合，罗列出每个分支当中包含的所有自负

isEnd：布尔值，表示该节点是否为某字符串的结尾

根节点是空的

最基本操作：创建

方法：遍历一遍输入的字符串，对每个字符串的字符进行遍历

最基本操作：搜索

### 212单词搜索II

```java

```

## 线段树SegmentTree

方法一：遍历一遍数组O(n)

方法二：线段树 O(logn)

#### [315. 计算右侧小于当前元素的个数](https://leetcode.cn/problems/count-of-smaller-numbers-after-self/)(困难)

```java

```

## 树状数组FenwickTree/ Binary Indexed Tree

#### [308. 二维区域和检索 - 可变](https://leetcode.cn/problems/range-sum-query-2d-mutable/)(困难)

# 排序-测试用例

```java
// "static void main" must be defined in a public class.

public class Solution{
    //交换位置
       public static void swap(int[] arr, int i , int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp; 
    }
    //选择排序
    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //0~n-1
        //1~n-1
        int N = arr.length;
        for(int i = 0; i < N; i++){
            //0 ~ n-1
            //i ~ n-1
            int minValueIndex = i;
            for(int j = i + 1; j < N; j++){
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr,i, minValueIndex);
            
            
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //0~n-1
        //0~n-2
        //0~end
        int N = arr.length;
        for(int end = N - 1; end >= 0;end--){
            //0~end 干一堆
            //0 1 ,1 2, 2 3 ,3 4, 4 5 end-1 end
            for(int second = 1; second <= end; second++){
                if(arr[second - 1] > arr[second]){
                    swap(arr, second - 1, second);
                }   
            }
        }
    }
    //插入排序
    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //0～0 完成
        //0～1 让范围上有序
        //0～2
        //0～n-1
        int N = arr.length;
        for(int end = 1; end < N;end++){
            int newNumIndex = end;
            while(newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]){
                swap(arr, newNumIndex-1, newNumIndex);
                newNumIndex--;
            }
        }
    }
    //插入排序优化2
    public static void insertSort2(int[] arr ){
        if(arr == null || arr.length < 2){
            return;
        } 
        int N = arr.length;
        for(int end = 1; end < N;end++){
            //pre新数的前一个位置
            for(int pre = end - 1;pre >= 0 && arr[pre] > arr[pre + 1]; pre--){
                swap(arr, pre, pre + 1);
            } 
        }
    }
 
    
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }
        
    public static void main(String[] args) {
       int[] arr = {0,1,20, 1, 3, 5, 11, 10};
        printArray(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        //insertSort(arr);
        insertSort2(arr);
        printArray(arr);
    }
}   



```

选择排序

```java
// "static void main" must be defined in a public class.
//选择排序
public class Solution{
    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //0~n-1
        int N = arr.length;
        for(int i = 0; i < N; i++){
            //0 ~ n-1
            //i ~ n-1
            int minValueIndex = i;
            for(int j = i + 1; j < N; j++){
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr,i, minValueIndex);
            
            
        }
    }
    public static void swap(int[] arr, int i , int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp; 
    }
    
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + "");
        }
        System.out.println();
    }
        
    public static void main(String[] args) {
       int[] arr = {20, 1, 3, 5, 11, 10};
        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }
}   

```



## 冒泡排序

冒泡排序的算法思想

每一轮，从杂乱无章的数组从头部开始，每两个元素比较大小并进行交换；

冒泡排序代码示例

```java
void sort(int[] nums){
  boolean hasCHange = true;
  for(int i = 0; i < nums.length - 1 && hasChange; i++){
    hasChange = false;
    for(int j = 0; j < nums.length -1 - i;j++){
      if(nums[j] > nums[j + 1]){
        swap(nums, j,j + 1);
        hasChange = true;
      }
    }
  }
}
```

## 插入排序 InsertionSort

插入排序的算法思想

不断地将尚未排好序的数插入到已经排好序的部分。

插入排序代码示例

```java
void sort(int[] nums){
  for(int i = 1,jcurret; i < nums.length;i++){
    current = nums[i];
    foor(j = i - 1; i >= 0 && nums[j] > current; j--){
      nums[j + 1] = nums[j];
    }
    nums[j + 1] = current;
  }
}
```

## 归并排序

分治的思想：归并排序的核心思想是分治，把一个复杂问题折成若干个子问题来求解。

归并排序代码实例

```java
void sort（int[] A,int lo, int hi）{
  if(lo >= hi) return;
  int mid = lo + (hi -lo) / 2;
  sort(A,lo,mid);
  sort(A,mid + 1, hi);
  merge(A,lo,mid,hi);
}

void merge( int[] nums, int lo , int mid, int  hi){
  int[] copy = nums.clone();
  int k = lo,i = lo,j = mid + 1;
  while(k <= hi){
    if(i > mid){
      nums[k++] = copy[j++];
    }else if(j > hi){
      nums[k++] = copy[i++];
    }else if(copy[j] < copy[i]){
      nums[k++] = copy[j++];
    }else{
      nums[k++] = copy[i++];
    }
  }
}
```

时间复杂度：T(n) 

归并算法是一个不断递归的过程，假设数组的元素个数是n

空间复杂度O(n)

由于合并n个元素需要分配一个大小为n的额外数组，合并完成之后，这个数组的空间就会被释放。

## 快速排序

快序排序的算法思想：快速排序采用了分治的思想；

```java
void sort（int[] nums,int lo,int hi）{
  if(lo >= hi) return;
  int p = partition(nums,lo,hi);
  sort(nums,lo, p - 1);
  sort(nums,p + 1,hi);
}
int partition(int[] nums, int lo,int hi){
  swap(nums,randRange(lo,hi),hi);
  int i,j;
  for(i = lo,j = lo,j < hi;j++){
    if(nums[j] <= nums[hi]){
      swap(nums,i++,j);
    }
  }
  swap(nums,i,j);
    return i;
}
```

## 递归

```java
int numDecodings(String s){
  char[] chars = s.toCharArray();
  return decode(chars,chars.length - 1);
}
int decode(char[] chars,int index){
  if(index <= 0){
    return 1;
  }
  int count = 0;
  char curr = chars[index];
  char prev = chars[index - 1];
}
if(curr > '0'){
  count = decode(chars, index - 1);
}
if(prev == '1' || (prev == '2' && curr <= '6')){
  count += decode(chars,index - 2);
  re
}
return count;
}

function fn(n){
  //第一步：判断输入或者化妆台是否非法？
  if(input/state is invalid){
    return;
  }
  //第二步：判断递归是否应当结束？
  if(match condition){
    return some value;
  }
  //第三步：缩少问题规模
  result1 = fn(n1)
  result2 = fn(n2)
    //第四步：整合结果
    return combine(result1, result2)
}
```

## 动态规划

300.最长序列的长度

```java
class Solution{
  public int lengthOfLIS(int[] nums){
    if(nums.length == 0){  // 如果序列为空，则最长上升子序列长度为0
      return 0;
    }
    int[] dp = new int[nums.length]; // 创建一个长度为 nums.length 的数组 dp，用来存储以每个元素为结尾的最长上升子序列的长度
    dp[0] = 1; // 默认以第一个元素结尾的最长上升子序列长度为1
    int maxans = 1; // 初始化整个序列的最长上升子序列长度为1
    for(int i = 1; i < nums.length;i++){ // 从第二个元素开始遍历整个序列
      dp[i] = 1; // 默认以当前元素结尾的最长上升子序列长度为1
      for(int j = 0; j < i;j++){ // 遍历当前元素之前的所有元素
        if(nums[i] > nums[j]){ // 如果当前元素大于前面的某个元素，则可以将当前元素加入到该元素结尾的最长上升子序列中
          dp[i] = Math.max(dp[i],dp[j] + 1); // 更新以当前元素结尾的最长上升子序列的长度
        }
      }
      maxans = Math.max(maxans,dp[i]); // 更新整个序列的最长上升子序列长度
    }
    return maxans; // 返回整个序列的最长上升子序列长度
  }
}

O(n)
O(n^2)
```





自底向上

```java
class LISDP{
  public int LIS(int[] nums,int n){
    int[] cache = new int[n];
    int i , j, max = 0;
    for(i = 0 ; i< n;i++){
      cache[i] = 1;
      for(i = 0; i < n;i++){
        for(j = 0 ;j < i;j++){
          if(nums[j] < nums[i] && cache[i] <cache[j] + 1 ){
            cache[i] = cache[j] + 1; 
          }
        }
        max = Math.max(max.cache[i]);
      }
      return max;
    }
  }
}
```

线性规划

70.爬楼梯

```java
public int climbStairs(int n) {
    int p = 0, q = 0, r = 1; // 初始化 p、q、r 三个变量，用于记录前两个斐波那契数和当前斐波那契数
    for(int i = 1; i <= n; ++i) {
        p = q; // 将 q 赋值给 p，因为 q 表示的是前一个斐波那契数
        q = r; // 将 r 赋值给 q，因为 r 表示的是当前斐波那契数
        r = p + q; // 计算当前斐波那契数
    }
    return r; // 返回第 n 个斐波那契数
}

```

198.

```java
public int rob(int[] nums) {
    int n = nums.length;
    if(n == 0) return 0; // 边界条件：空数组的最大收益为 0
    if(n == 1) return nums[0]; // 边界条件：只有一个房子的最大收益为该房子的金额
    int[] dp = new int[n]; // dp[i] 表示到第 i 个房子为止能够偷到的最大金额
    dp[0] = nums[0]; // 初始化第 0 个房子的最大收益为该房子的金额
    dp[1] = Math.max(nums[0],nums[1]); // 初始化第 1 个房子的最大收益为第 0 个房子和第 1 个房子中的较大值
    for(int i = 2; i < n; i++){
        // 状态转移方程：dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
        // 如果偷第 i 个房子，那么最大收益为前 i - 2 个房子的最大收益加上第 i 个房子的金额；
        // 如果不偷第 i 个房子，那么最大收益为前 i - 1 个房子的最大收益。
        dp[i] = Math.max(nums[i] + dp[i - 2],dp[i - 1]); 
    }
    return dp[n - 1]; // 最后返回到第 n - 1 个房子为止能够偷到的最大金额
}

```



# 高频题精讲

## 3.无重复字符的最长自串（中等）

解法一：暴力法

长度为1的子串，有n个，长度为2的子串，有n-1个

长度为k的子串，有n-k+1个

当k=n时，n-k+1=1，既长度为n的子串就是1个

```java

```

解法二：线性法

使用快慢指针策略，字符串最多被遍历两次

快指针会被添加到哈希表结合，慢指针遇到的字符会从哈希集合中删除

O(1).

空间复杂度分析:O(n)

```java
int lengthOfLongestSubstring(String s){
  //定义一个哈希集合set，初始化结果max为0
  Set<Character> set = new HashSet<>();
  int max = 0;
  //利用快慢指针i和j扫描一遍字符串
  for(int i = 0;j < s.length();j++){
    //如果快指针指向的字符已出现在哈希集合，不断尝试将慢指针向字符从哈希集合中删除
    while(set.contains(s.charAt(j))){
      set.remove(s.charAt(i));
      i++
    }
    //当快指针的字符终于能加入到哈希集合，更新结果max
    set.add(s.charAt(j));
    max = Math.max(max.set.size());
  }
  //遍历完毕后，返回结果max
  return max;
}
```

解法三：优化的线性法

```java
int lengthOfLongestSubstring(String s){
  //定义一个哈希集合set记录上次某字符出现的位置，初始化结果max为0
  Map<Character,Integer> map = new HashMap<>();
  int max = 0;
  //利用快慢指针所对应的字符已经出现过，慢指针就进行跳跃
  for(int i = 0,j =0;j < s.length();j++ ){
    if(map.containsKey(s.charAt(j))){
      i = Math.max(i, map.get(s.charAt(j)) + 1);
    }
  }
  //把快指针所对应的字符添加到哈希表中
  map.put(s.charAt(j),j);
  //更新结果为max
  max = Math.max(max,j - i + 1);
}
//返回结果max
return max;
}
```

## 4.寻找两个有序数组的中位数（困难）

解法一：暴力法

利用归并排序思想将他们合并成一个长度为m+n的有序数组

合并的时间复杂度为m+n，从中选取中位数，整体时间发咋读为O(m+n)

```java

```

解法二：切分法

```java
doublie finMedianSortedArrays(int nums1[],int nums2[]){
  int m = nums1.length;
  int n = nums2.length;
  int k = (m + n) / 2;
  if((m + n ) & 2 == 1){
    return findKth(nums1,0,m - 1, nums2,0,n - 1,k +1);
  }else{
    return (
    findKth(nums1,0,m - 1 ,nums2,0,n - 1,k) + 
    findKth(nums1,0,m - 1 ,nums2,0,n - 1,k + 1) / 2.0;
  }
}
      
```

## [215. 数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/)

场景：快速选择算法

```java
class Solution{
  Random random = new Random();
  public int findKthLargest(int[] nums,int k ){
    retrun quickSelect(nums,0,nums.length - 1, nums.length - k);
  }
  public int quickSelect(int[] a ,int l, int r, int index){
    int q = randomPartition(a,l ,r);
    if(q ==index){
      return a[q];
    }else{
      return q <index ?quickSelect(a,q + 1,index ):quickSelect(a,l, q - 1,index);
    }
  }
  public int randomPartition()
}
```

## 23.合并K个排列链表（困难)

解法一：暴力法

```java

```

解法二：最小堆

```

```

解法三：分治法

```java

```



# 算法复杂度

## 时间复杂度

输入数据大小为N时，算法运行所需花费的时间。

比如，计算机操作随数据大小N变化时的变化情况，假设算法运行总需要1次操作，100次操作，都为常数级）O(1).需要N次操作，100N次操作的时间复杂度都为O(n).

```java
//： 线性查找，即遍历整个数组，遇到 7，则返回 true
boolean findSeven(int[] nums){
  for(int num : nums){
    if(num == 7){
      return true;
    }
    return false;	
  }
}
//常数O(1)
int algorithm(int N){
  int a = 1;
  int b = 2;
  int x = a * b + N;
  return 1;
}
//无论a取多大，与输入数据大小为N无关，因此时间复杂度为O(1)
int algorithm(int N){
  int count = 0;
  int a = 10000;
  for(int i = 0; i < a; i++){
    count++;
  }
  return count;
}

//线性O(N)
int algorithm(int N){
  int count = 0;
  for(int i = 0; i < N; i++){
    count++;
  }
  return count;
}

//对于以下代码，虽然是两层循环，但第二层与N大小无关，因此整体仍与N呈线性关系。
int algorithm(int N){
  int count  = 0;
  int a = 10000;
  for(int i = 0 ; i < N;i++){
    for(int j = 0; j < a;j++){
      count++;
    }
  }
  return count;
}

//平方O(N2)
int algorithm(int N){
  int count = 0;
  for(i = 0; i < N;i++){
    for(j = 0 ; j < N;j++){
      count++;
    }
  }
  return count;
}

//冒泡排序为例，其包含两侧独立循环
//冒泡排序的总体时间复杂度O(N2)
int[] bubbleSort(int[] nums){
  int N = nums.length;
  for(int i = 0; i < N - 1; i++){
    for(int j = 0; j < N - 1 - i;j++){
      if(nums[i] > nums[j + 1]){
        int tmp = nums[j];
        nums[j] = nums[j + 1];
        nums[j + 1] = tmp;
      }
    }
  }
  return nums;
}

//指数O(2N),指数阶常出现于递归
int algorithm(int N){
  if(N <= 0){
    return 1;
  }
  int count_1 = algorithm(N - 1);
  int count_2 = algorithn(N - 1);
  return count_1 + count_2;
}


//阶乘O(N!),阶乘常使用递归实现
int algorithm(int N){
  if(N <= 0){
    return 1;
  }
  int count = 0;
  for(int i = 0; i < N;i++){
    count += algorithm(N - 1);
  }
  return count;
}


//对数O(logN)对数阶常出现于「二分法」、「分治」等算法中，体现着 “一分为二” 或 “一分为多” 的算法思想。

int algorithm(int N){
  int count = 0;	
  float i = N;
  while(i > 1){
    i = i / 2;
    count++;
  }
  return count;
}

//线性对数O(NlogN)
int algorithm(int N){
  int count = 0;
  float i = N;
  while(i > 1){
    i = i / 2;
    for(int j = 0; j < N;j++){
      count++;
    }
  }
   return count;
}
```

空间复杂度





### 剑指 Offer 14- I. 剪绳子

```java
class Solution{
  public int cuttingARope(int n ){
    if(n <= 3){
      return -1;
    }
    int a = n / 3;
    int b = n % 3;
    if(b == 0){
      return (int)Math.pow(3, a);
    }
    if(b == 1){
      return (int)Math.pow(3, a - 1) * 4;
    }
    return (int)Math.pow(3, a) * 2;
  }
}
```



# Java算法

## 列表

**由于长度不可变，数组的实用性大大降低**

诞生了一种被称为「列表 List」的数据结构。

**初始化列表**。我们通常会使用到“无初始值”和“有初始值”的两种初始化方法。

```java
//无初始值
List<Integer>	list  = new ArrayList<>();
//有初始值
Integer[] numbers = new Integer[]{1,2,3,7,6};
List<Integer> list = new ArrayList<>(Array.asList(numbers));
```

**访问与更新元素**。列表的底层数据结构是数组，因此可以在 �(1) 时间内访问与更新元素，效率很高。

```java
	//访问元素
	int num = list.get(1);//访问索引1处的元素
	//更新元素
	list.set(1,0)// 将索引 1 处的元素更新为 0
```

**在列表中添加、插入、删除元素**。

```java
//清空列表
list.clear();
//尾巴添加元素
list.add(1);
//中间插入元素
list.add(1,35);
list.remove(1);
```

遍历

```java
//遍历索引列表  (最好用)
int count = 0;
for(int i = 0; i < list.size(),i++ ){
	count ++;
}
//直接遍历列表元素
count = -;
for(int n : list){
  count ++;
}
```

拼接两个列表

```java
List<Integer> lsit1 = new ArrayList<>(Arrays.aslist(new Integer)[]{5,7,8,9}));
list.addAll(lsit1);//将列表list1拼接到list后
```

排序列表

```java
Collections.sort(list);
```

列表简单实现

```java
class Mylsit{
  private int[] nums;// 数组（存储列表元素）
  private int capactity = 10;//列表容量
  private in size = 0;//列表长度（即当前元素数量）
  private in extendRatio = 2;	//每次列表扩容的倍数
}
//构造方法
 public Mylist() {
   nums = new int [capactity];
 }
//获取列表长度（当前元素的数量）
 public int size(){
   return size;
 } 
//获取列表容量
 public int capactity(){
   return capactity;
 } 
//访问元素
 public int get(int index){
   if(index < 0 ||index >= size){
     throw new IndexOutOfBoundsException("索引越界");
     return nums[index];
  }
  //更新元素
  public int set(int index){
    if(idnex < 0 || index >= size){
      throw new IndexOutOfBoundsException("索引越界");
      nums[index] = num;
    }
    
    //中间插入元素
    public void insert (int index , int nnum){
      if(index < 0 || idnex >=size){
        throw new IndexOutOfBoundsException("索引越界");
        //元素超出容量时，出发扩容机制
        if(size == capactity())
          extendCapactity());
        //将索引index以及后的元素都向后移动一位
        for(int j = size -1;j>=index;j--){
          nums[j + 1] = nums[j];
        }
        //更新元素数量
        size --;
      }
      //返回删除元素
      return num;
    }
    
    //列表扩容
    public void extendCapacity(){
      // // 新建一个长度为 size 的数组，并将原数组拷贝到新数组
      nums =	Arrays.copyOf(nums,capacity() * extendRatio);
      //更新列表容量
      capacity = nums.length;
    }
    
    //将列表转换为数组
    public int[] toArray(){
      int size = size();
      //仅转换有效长度范围内的列表元素
      int[] nums = new int [size];
      for(int i = 0 ; i < size	; i++){
        nums[i] = get(i);
      }
      return nums;
    }
  } 
 }
```



## 栈与队列

「栈 Stack」是一种遵循「先入后出」数据操作规则的线性数据结构

### 栈

```java
//初始化栈
Stack<Integer> stack = new Stack<>();
//元素入栈
stack.push(1);
stack.push(2);
//访问栈顶元素
in peek = stack.peek();
//元素出栈
in pop = stack.pop();
//获取栈的长度
int size = stack.size();
//判断是否为空
boolean	isEmpty = stack.isEmpty;
```

链表实现栈的示例代码

```java
class LinkedStack{
  private ListNode stackPeek;//将头作为栈顶
  private int stkSize = 0;//栈的长度
  
  private LinkedListStack(){
    stackPeek = null;
  }
  public int size(){
    return stkSize;
  }
  //判断栈是否为空
  public boolean isEmpty(){
    return size() == 0;
  }
  //入栈
  public void push(int num){
    ListNode node = stackPeek;
    stackPeek = node;
    stkSize++;
  }
  
  pubic int pop(){
    int num = peek();
    stackPeek = stackPeek.next；
      stkSize--;
  }
  punlic int peek(){
    if(size == 0 )
      throw new EmptyStackException();
    return stackPeek.val;
  }
  public int[] toArray(){
    ListNode node = stackPeek;
    int[] res = new int[size()];
    for(int i = res.length - 1 ; i >= 0 ;i--){
      res[i] = node.val;
      node = node.next;
    }
    return res;
  }
}
```

队列

```java
//初始化队列
Queue<Integer> queue = new LinkedList<>();
queue.offter(1);//元素入队
int peek = queue.peek();// 访问队首元素 
/* 元素出队 */
int pop = queue.poll();
/* 获取队列的长度 */
int size = queue.size();
/* 判断队列是否为空 */
boolean isEmpty = queue.isEmpty();
```

基于链表实现的队列

```java
// 基于链表实现的队列
class LinkedListQueue {
    private ListNode front, rear;  // 头节点 front ，尾节点 rear 
    private int queSize = 0;  // 队列元素个数

    // 构造函数，初始化队列为空
    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    // 获取队列的长度
    public int size() {
        return queSize;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    // 入队
    public void push(int num) {
        // 创建一个新的节点，并将尾节点指向该节点
        ListNode node = new ListNode(num);
        // 如果队列为空，则令头、尾节点都指向该节点
        if (front == null) {
            front = node;
            rear = node;
        // 如果队列不为空，则将该节点添加到尾节点后
        } else {
            rear.next = node;
            rear = node;
        }
        // 更新队列元素个数
        queSize++;
    }

    // 出队
    public int pop() {
        int num = peek();
        // 删除头节点
        front = front.next;
        // 更新队列元素个数
        queSize--;
        return num;
    }

    // 访问队首元素
    public int peek() {
        if (size() == 0)
            throw new EmptyStackException();  // 抛出队列为空的异常
        return front.val;
    }

    // 将链表转化为 Array 并返回
    public int[] toArray() {
        ListNode node = front;
        int[] res = new int[size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = node.val;  // 将节点值存入数组
            node = node.next;  // 移动到下一个节点
        }
        return res;  // 返回转化后的数组
    }
}

```

## 哈希表

遍历哈希表有三种方式，即 **遍历键值对、遍历键、遍历值**。

```java
Map<Integer, String> map = new HashMap<>();
map.put(1234,"小哈");

String name = map.get(1233);
map.remove(1234);
/* 遍历哈希表 */
// 遍历键值对 key->value
for (Map.Entry <Integer, String> kv: map.entrySet()) {
    System.out.println(kv.getKey() + " -> " + kv.getValue());
}
// 单独遍历键 key
for (int key: map.keySet()) {
    System.out.println(key);
}
// 单独遍历值 value
for (String val: map.values()) {
    System.out.println(val);
}

```

哈希函数工作原理

```java
/* 键值对 int->String */
class Entry {
    public int key;
    public String val;
    public Entry(int key, String val) {
        this.key = key;
        this.val = val;
    }
}

/* 基于数组简易实现的哈希表 */
class ArrayHashMap {
    private List<Entry> buckets;
    public ArrayHashMap() {
        // 初始化数组，包含 100 个桶
        buckets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            buckets.add(null);
        }
    }

    /* 哈希函数 */
    private int hashFunc(int key) {
        int index = key % 100;
        return index;
    }

    /* 查询操作 */
    public String get(int key) {
        int index = hashFunc(key);
        Entry pair = buckets.get(index);
        if (pair == null) return null;
        return pair.val;
    }

    /* 添加操作 */
    public void put(int key, String val) {
        Entry pair = new Entry(key, val);
        int index = hashFunc(key);
        buckets.set(index, pair);
    }

    /* 删除操作 */
    public void remove(int key) {
        int index = hashFunc(key);
        // 置为 null ，代表删除
        buckets.set(index, null);
    }

    /* 获取所有键值对 */
    public List<Entry> entrySet() {
        List<Entry> entrySet = new ArrayList<>();
        for (Entry pair : buckets) {
            if (pair != null)
                entrySet.add(pair);
        }
        return entrySet;
    }

    /* 获取所有键 */
    public List<Integer> keySet() {
        List<Integer> keySet = new ArrayList<>();
        for (Entry pair : buckets) {
            if (pair != null)
                keySet.add(pair.key);
        }
        return keySet;
    }

    /* 获取所有值 */
    public List<String> valueSet() {
        List<String> valueSet = new ArrayList<>();
        for (Entry pair : buckets) {
            if (pair != null)
                valueSet.add(pair.val);
        }
        return valueSet;
    }

    /* 打印哈希表 */
    public void print() {
        for (Entry kv: entrySet()) {
            System.out.println(kv.key + " -> " + kv.val);
        }
    }
}
	
```



## 查找

### [704. 二分查找]

两种模版代码

```java
boolean check(int x){}
in search(int left,int right){
  while(left < right){
    int mid = (left + right ) >> 1;
    if(check(mid)){
      right = mid;
    }else{
      left = mid + 1;
    }
  }
  return left;
}

boolean check(int x){}
int search(int left,int right){
  whie(left < right){
    int mid = (left + right + 1 ) >> 1;
    if(check(mid)){
      left = mid;
    }else{
      right = mid - 1;
    }
  }
  return left
}
```

第一种方法

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) >>> 1;
            if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}

```

第二种方法，比第一种方法效率高

```java
class Solution {
    public int search(int[] nums, int target) { // 在 nums 中查找 target 的索引位置
        int left = 0; // 定义左边界
        int right = nums.length - 1; // 定义右边界
        while (left <= right) { // 当左边界小于等于右边界时，进行二分查找
            int mid = left + (right - left) / 2; // 计算中间位置
            if (nums[mid] == target) { // 如果中间位置的值等于目标值，返回中间位置
                return mid;
            } else if (nums[mid] > target) { // 如果中间位置的值大于目标值，缩小右边界
                right = mid - 1;
            } else { // 如果中间位置的值小于目标值，缩小左边界
                left = mid + 1;
            }
        }
        return -1; // 如果没找到目标值，返回 -1
    }	
}

```

### x的平方根

```java
class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
```

- 时间复杂度：O(log⁡x)，即为二分查找需要的次数。
- 空间复杂度：O(1)

### [35. 搜索插入位置](https://leetcode.cn/problems/search-insert-position/)

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0 , right = n -1 , ans =n;
        while (left <= right) {
            int mid =((right - left) >> 1) +left ; 
            if (target <= nums[mid]) {
                ans = mid ;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return  ans;
    }
}
```

### [977. 有序数组的平方](https://leetcode.cn/problems/squares-of-a-sorted-array/)

```java
//第一种直接排序 
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}

//第二种
class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n);
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            }
            else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
};

```

数组算法

int[] arr = new int [5]

int[] nums = {1,2,3,4,5]} 



## 链表

```java
//单链表中结点的典型定义：
public class SinglyListNode{
  //"val"是变量的标识符，当前节点存储的整数值
  int val；
  //当前节点的下一个节点
  SinglyListNode next;
  // // 构造方法，用于创建一个新的节点并初始化其"value"成员变量
  SinglyListNode (int x ){
    val = x;
  }
}
```

### 26题删除有序数数组中的重复项

```java
int removeDuplicates(int[] nums){
  if(nums.length == 0){
    return 0;
  }
  int slow = 0; 
  int fast = 0;
  while(fast < nums.length ){
    if(nums[fast] != nums[slow]){
      slow++;
      nums[slow] = nums[fast];
    }
    fast++;
  }
  return slow + 1;
}
```

### 第27题移动元素

```java
int removeElement(int[] nums,int val){
  int fast = 0;
  int slow = 0;
  while(fast < nums.length){
    if(nums[fast] != val){
      nums[slow] = nums[fast];
      slow++;
    }
    fast++;
  }
  return slow;
}
```

第83题排序链表中的重复元素

```java
ListNode deleteDuplicates(ListNode head){
  if(head == null){
    return null;
  }
}
```



### 设计链表

1.简单：第一种方法

```java
class ListNode {
    int val; // 节点值
    ListNode next; // 指向下一个节点的指针

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {
    ListNode head; // 链表头节点
    int size; // 链表长度

    public MyLinkedList() {
        head = new ListNode(0); // 创建一个值为0的头节点
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) { // 下标无效
            return -1;
        }
        ListNode cur = head.next;
        for (int i = 0; i < index; i++) { // 遍历找到指定节点
            cur = cur.next;
          
        }	
        return cur.val; // 返回节点值
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val); // 创建新节点
        node.next = head.next; // 将新节点插入头节点之后
        head.next = node;
        size++; // 长度加1
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val); // 创建新节点
        ListNode cur = head;
        while (cur.next != null) { // 找到尾节点
            cur = cur.next;
        }
        cur.next = node; // 将新节点插入尾节点之后
        size++; // 长度加1
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) { // 下标无效
            return;
        }
        ListNode node = new ListNode(val); // 创建新节点
        ListNode cur = head;
        for (int i = 0; i < index; i++) { // 遍历找到指定节点之前的节点
            cur = cur.next;
        }
        node.next = cur.next; // 将新节点插入指定节点之前
        cur.next = node;
        size++; // 长度加1
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) { // 下标无效
            return;		
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) { // 遍历找到指定节点之前的节点
            cur = cur.next;
        }
        cur.next = cur.next.next; // 将指定节点删除
        size--; // 长度减1
    }
}

```

代码以上，不好使用。

第二种

非常推荐使用双链表：

```java
class MyLinkedList {
    int size;  // 链表大小
    ListNode head; // 头结点
    ListNode tail; // 尾结点

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0); // 创建虚拟头结点
        tail = new ListNode(0); // 创建虚拟尾结点
        head.next = tail; // 虚拟头结点的 next 指向虚拟尾结点
        tail.prev = head; // 虚拟尾结点的 prev 指向虚拟头结点
    }

    // 获取链表中第 index 个结点的值
    public int get(int index) {
        if (index < 0 || index >= size) { // index 不合法，返回 -1
            return -1;
        }
        ListNode curr;
        if (index + 1 < size - index) { // 从头结点开始查找
            curr = head;
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
        } else { // 从尾结点开始查找
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.prev;
            }
        }
        return curr.val; // 返回第 index 个结点的值
    }

    // 在链表头部添加结点
    public void addAtHead(int val) {
        addAtIndex(0, val); // 直接调用 addAtIndex 方法，在 index 为 0 的位置插入结点
    }

    // 在链表尾部添加结点
    public void addAtTail(int val) {
        addAtIndex(size, val); // 直接调用 addAtIndex 方法，在 index 为 size 的位置插入结点
    }

    // 在链表的第 index 个位置插入结点
    public void addAtIndex(int index, int val) {
        if (index > size) { // 如果 index 不在链表范围内，不执行操作
            return;
        }
        index = Math.max(0, index); // 如果 index 小于 0，则插入在链表头部
        ListNode pred, succ;
        if (index < size - index) { // 从头结点开始查找
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next;
        } else { // 从尾结点开始查找
            succ = tail;
            for (int i = 0; i < size - index; i++) {
                succ = succ.prev;
            }
            pred = succ.prev;
        }
        size++; // 链表大小加 1
        ListNode toAdd = new ListNode(val); // 创建要插入的结点
        toAdd.prev = pred; // 新结点的 prev 指向插入位置的前一个结点
        toAdd.next = succ; // 新结点的 next 指向插入位置的后一个结点
        pred.next = toAdd; // 插入位置的前一个结点的 next 指向新结点
        succ.prev = toAdd; // 插入位置的后一个结点的 pre
    }
 public void deleteAtIndex(int index) {
    // 检查索引是否合法
    if (index < 0 || index >= size) {
        return;
    }
    // 定义前驱节点 pred 和后继节点 succ
    ListNode pred, succ;
    if (index < size - index) { // 判断删除的节点在链表前半部分还是后半部分
        // 如果在前半部分，从头节点开始遍历找到要删除的节点的前一个节点 pred 和后一个节点 succ
        pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        succ = pred.next.next;
    } else {
        // 如果在后半部分，从尾节点开始遍历找到要删除的节点的前一个节点 pred 和后一个节点 succ
        succ = tail;
        for (int i = 0; i < size - index - 1; i++) {
            succ = succ.prev;
        }
        pred = succ.prev.prev;
    }
    // 修改链表节点数
    size--;
    // 修改前驱节点和后继节点的指针，将要删除的节点从链表中删除
    pred.next = succ;
    succ.prev = pred;
}

class ListNode {
    int val; // 节点存储的值
    ListNode next; // 后继节点指针
    ListNode prev; // 前驱节点指针

    public ListNode(int val) 
        this.val = val;
    }
}

```

### 环形链表

给你一个链表的头节点 head ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。

如果链表中存在环 ，则返回 true 。 否则，返回 false 。

```java
public class Solution{
  public boolean hayCycle(ListNode head){
    //如果head为Null,那么链表肯定不存在，直接返回false
    if(head == null ||head.next == null)
      return false;
    //初始化慢指针slow和快指针fast，都向head节点
    	ListNode slow = head;
    	ListNode fast = head;
    //只要快指针fast和它的下一个节点都不为null，就继续循坏
    while(fast != null && fast.next != null){
      slow = 	slow.next;
      fast = fast.next.next;
      //如果慢指针和快指针相遇，说明链表存在环，直接返回true
      if(slow =fast )
        return true;
    }
    //否则， 链表不存在环，返回false
   
    return false;
  }	
}
```

使用哈希表代码：

```java
public ListNode detectCycle(ListNode head) {
    // 定义一个哈希表
    Set<ListNode> visited = new HashSet<>();

    // 遍历链表中的每个节点
    while (head != null) {
        if (visited.contains(head)) { // 如果该节点已经出现过，则说明链表存在环
            return head;
        }
        visited.add(head); // 将该节点加入到哈希表中
        head = head.next; // 将指针向后移动一个节点
    }

    return null; // 如果链表不存在环，则返回 null
}

```

**这两段代码的思路是相同的，都是使用快慢指针来判断链表是否存在环。但是，它们的功能不同。第一段代码仅仅判断链表是否存在环，而第二段代码在判断链表是否存在环的基础上，还找到了环的入口节点并返回该节点。因此，第二段代码的功能更加全面，比第一段代码更加复杂。**

### 环形链表2

给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。不允许修改 链表。

**温馨提醒**:题目要求不可以修改链表，是因为在实际场景中，链表可能被多个线程共享。如果修改链表，可能会破坏链表的完整性，导致其他线程访问链表时出现错误。另外，链表是一种常见的数据结构，不同的算法需要用到不同的操作，保持链表的不变性可以增加算法的复用性和可维护性。因此，为了保证链表数据结构的完整性和稳定性，不允许修改链表。

```java
class Solution{
public ListNode deteCycle(ListNode head){
  //如果链表为空，直接返回null
  	if(head == null)
      return; 
}
  //定义链表快慢指针
  ListNode slow = head;
  ListNode fast = head;
  //快慢指针找到相遇点
  while(fast != null && fast.next != null){
    //慢指针每次向后移动一个节点
    slow = slow.next;
    //快指针每次向后移动两个节点
    fast = fast.next.next;
    //快慢指针相遇，说明了链表存在环
    if(slow == fast ){
      break;//使用 break 语句来跳出循环。在这种情况下，仍然需要继续执行后面的代码，以判断链表是否有环，并返回相应的结果。
      //如果代替return语句，不会继续执行后面的代码。
    }
  }
  
  //判断链表是否有环
  if(fast == null || fast.next == null ){
    return null;
  }  
  //将快指针重新指向链表的头节点
  fast =head;
  //快慢指针再次相遇，即为环的入口节点
  while(slow != fast){
    //快慢指针每次向后移动一个节点，直到相遇
    slow = slow.next;
    fast = fast.next;
  }
  //返回环入口节点
  return slow;
  
}

```

**为什么要找到环的入口节点呢？因为在实际开发中，有时候需要找到环的入口节点来进行一些操作，比如删除环的节点，或者打破链表的环等。所以，在判断链表是否有环的基础上，找到环的入口节点也是一个重要的问题。**

### 相交链表

基本代码：

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if(headA == null || headB == null ){
        return null;
      }
      //nodeA和nodeB被定义为了headA和headB	
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while (nodeA != nodeB) {
            nodeA = nodeA != null ? nodeA.next : headB;  // 如果 nodeA 不为 null，则继续往后走，否则从链表 B 的头结点开始走
            nodeB = nodeB != null ? nodeB.next : headA;  // 如果 nodeB 不为 null，则继续往后走，否则从链表 A 的头结点开始走
        }
        
        return nodeA;  // 返回相交节点（如果链表不相交，则返回 null）
    }
}

```

### 反转链表

```java
public ListNode reverseList(ListNode head) {
    // 初始化三个指针，分别指向前一个节点、当前节点和下一个节点
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;
    // 遍历链表
    while (curr != null) {
        // 将当前节点的下一个节点保存到 next 变量中
        next = curr.next;
        // 将当前节点的 next 指向前一个节点，实现反转
        curr.next = prev;
        // 将 prev 指向当前节点
        prev = curr;
        // 将 curr 指向下一个节点
        curr = next;
    }
    // 返回反转后的头节点
    return prev;
}
该代码使用三个指针（prev、curr 和 next）遍历链表，依次将链表中的每个节点反转。具体而言，首先将 curr 的 next 指向 prev，实现反转；然后，将 prev 指向 curr；最后，将 curr 指向 next，实现遍历。该算法的时间复杂度是 O(n)，其中 n 是链表的长度，因为需要遍历链表的每个节点。而空间复杂度是 O(1)，因为只需要使用三个指针来保存变量。
```



```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while(cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }
}
O(n) O(1)
```



## 二叉树

### 二叉树的前序遍历

```java

class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    preorder(root, res); // 调用 preorder 方法进行先序遍历
    return res; // 返回遍历结果
}

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
         return; // 递归结束条件
    }
    res.add(root.val); // 访问根节点
    preorder(root.left, res); // 递归遍历左子树
    preorder(root.right, res); // 递归遍历右子树
	}
}
```

### 二叉树的中序遍历

```java
class Solution{
  public List<Integer> inorderTraversal(TreeNode root){
    List<Integer> res = new ArrayList<Integer>();
    inorder(root,res); //调用inorder方法进行中序遍历
    return res;
  }
  public void inorder(TreeNode root, List<Integer> res){
    if(root == null){
      return;
    }
    inorder(root.left,res);//递归遍历左子树
    res.add(root.val);//访问根节点
    inorder(root.right,res);//递归遍历右子树
  }
}
```

### 二叉树的后序遍历

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder (root,res);
        return res;
    }
    public void postorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
}
```

### 二叉树的层序遍历

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); // 存储结果的列表
        int level = 0; // 当前遍历的层次

        Order(root, res, level); // 递归遍历二叉树
        return res; // 返回结果
    }

    public void Order(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) { // 当前节点为空，返回上一层
            level--;
            return;
        }
        
        if (res.size() < level + 1) { // 如果 res 中还没有记录当前层的节点值，则添加一个空列表表示当前层
            res.add(new LinkedList<>());
        }

        List<Integer> levelList = res.get(level); // 获取当前层的列表
        levelList.add(root.val); // 将当前节点的值添加到当前层的列表中

        Order(root.left, res, level + 1); // 递归遍历左子树
        Order(root.right, res, level + 1); // 递归遍历右子树
    }
}

```

## 排序算法

「排序算法 Sorting Algorithm」使得列表中的所有元素按照从小到大的顺序排列。

### 冒泡排序

- 冒泡排序算法，用于对传入的整型数组 nums 进行排序。

- 排序结果将直接影响原数组 nums

  

  ```java
  void bubbleSort(int[] nums) {
  	int N = nums.length;
  	for (int i = 0; i < N - 1; i++) {          // 外循环
  		for (int j = 0; j < N - i - 1; j++) {  // 内循环
  			if (nums[j] > nums[j + 1]) {
           // 交换 nums[j], nums[j + 1]
  				int tmp = nums[j];
  				nums[j] = nums[j + 1];
  				nums[j + 1] = tmp;
  			}
  		}
  	}
  }
  ```

  优化后

```java
class Solution{
	public void bubbleSort(int[] nums){
    //外循环：待排序元素数量为n-1，n-2...,1
    for(int i = nums.length - 1 ; i >= 0 ;i--){
      //初始化标志位
      boolean flag = false;
      //内循环：冒泡操作
      for(int j = 0; j < i; j++){
        if(nums[j] > nums[j + 1]){
  			 //int tmp = nums[j] 是将数组 nums 中的第 j 个元素的值赋给变量 tmp。在冒泡排序算法中，如果当前元素的值比下一个元素的值大，则需要交换它们的位置，这个过程中需要用到一个临时变量 tmp 来暂存当前元素的值，然后再将下一个元素的值赋给当前元素，最后再将临时变量 tmp 的值赋给下一个元素。
          int tmp = nums[j];
          //如果num[j]比nums[j+1]大，则交换它们的位置
          nums[j] = nums[j + 1];
          nums[j + 1] = tmp;
          flag = true;//记录交换元素
        	}
    	}
      //// 内循环未交换任何元素，则跳出
      if(!flag) break; 
  	}
	}
}
```

测试用例：

```java
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] nums = {5, 1, 9, 3, 7, 2};
        Solution solution = new Solution();
        solution.bubbleSort(nums);
        System.out.println(Arrays.toString(nums)); // [1, 2, 3, 5, 7, 9]
    }
}
```

考虑可以增加一个标志位 **`flag`** 来监听该情况，若出现则直接返回。优化后，冒泡排序的**最差和平均时间复杂度仍为 O(n2)** ；而在输入数组完全有序时，达到**最佳时间复杂度 O(n) 。**

### 快速排序

快速排序算法有两个核心点，分别为 **哨兵划分** 和 **递归** 。

#### 哨兵划分：

以数组某个元素（一般选取首元素）为 **基准数** ，将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边。

```java
void quickSort(int[] nums, int l, int r) {
    // 子数组长度为 1 时终止递归
    if (l >= r) return;
    // 哨兵划分操作
    int i = partition(nums, l, r);
    // 递归左（右）子数组执行哨兵划分
    quickSort(nums, l, i - 1);
    quickSort(nums, i + 1, r);
}

int partition(int[] nums, int l, int r) {
    // 以 nums[l] 作为基准数
    int i = l, j = r;
    while (i < j) {
        while (i < j && nums[j] >= nums[l]) j--;
        while (i < j && nums[i] <= nums[l]) i++;
        swap(nums, i, j);
    }
    swap(nums, i, l);
    return i;
}

void swap(int[] nums, int i, int j) {
    // 交换 nums[i] 和 nums[j]
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}

// 调用
int[] nums = { 4, 1, 3, 2, 5 };
quickSort(nums, 0, nums.length - 1);

```

优化后

```java
void quickSort(int[] nums, int l, int r) {
    // 子数组长度为 1 时终止递归
    while (l < r) {
        // 哨兵划分操作
        int i = partition(nums, l, r);
        // 仅递归至较短子数组，控制递归深度
        if (i - l < r - i) {
            quickSort(nums, l, i - 1);
            l = i + 1;
        } else {
            quickSort(nums, i + 1, r);
            r = i - 1;
        }
    }
}

//随机基准数：
int partition(int[] nums, int l, int r) {
    // 在闭区间 [l, r] 随机选取任意索引，并与 nums[l] 交换
    int ra = (int)(l + Math.random() * (r - l + 1));
    swap(nums, l, ra);
    // 以 nums[l] 作为基准数
    int i = l, j = r;
    while (i < j) {
        while (i < j && nums[j] >= nums[l]) j--;
        while (i < j && nums[i] <= nums[l]) i++;
        swap(nums, i, j);
    }
    swap(nums, i, l);
    return i;
}

```





### 插入排序

```java
public void insertSort(int[] nums){
  
}
```

### 桶排序

## 堆

```java
Queue<Integer> minHeap = new priotyQueue<>();
Queue<Integer> maxHeap = new priotyQueueM<>((a,b) -> b - a );

maxHeap.offter(1);
maxHeap.offter(2);

int peek = maxHeap.peek();

peek = heap.poll();
peek = head.poll();

int size = maxHeap.size();

boolean isEmpty = maxHeap.isEmpty();

minHeap = new PriorityQueue<>(Arrays.asList(1,2,3,4));

int left(int i){
  return 2 * i + 1;
}
int right(int i){
  return 2 * i + 2;
}
int parent(int i){
  return (i - 1)  / 2;
}

int peek(){
  return maxHeap.get(0);
}


void push(int val){
  maxHeap.add(val);
  siftUp(size() - 1);
}

void sifUp(int i){
  while(true){
    int p = parent(i);
    if(p < 0 || maxHeap.get(i) <= maxHeap.get(p))
      break;
    swap(i, p);
    i = p;
  }
}
int pop(){
  is((isEmpty)){
    throw new EmptyStackException();
    swap(0,size() - 1){
      int val = maxHeap.remove(size() - 1);
      siftDown(0);
      return val;
    }
  }
}

void siftDown(int i ){
  while(true){
    int l = left(i);
    int r = right(i);
   	int ma = i;
    if(l < size() && maxHeap.get(l) > maxHeap.get(ma)){
      ma = l;
    }
    if(r < size() && maxHeap.get(r) > maxHeap.get(ma)){
      ma = r;
    }
    if(ma == i){
      break;
    }
    swap(i,ma);
    i = ma;
  }
}
```

### 基于堆化操作实现

```java
MaxHeap(List<Integer> nums){
 maxHeap = new ArrayList<>(nums);
  for(int i = parent(size() - 1);
      i >= 0;i--{
        siftDown(i);
      }
}
```

## 回溯算法

**例题一：在二叉树中搜索并返回所有值为** **7** **的节点**

前序遍历这颗树，并判断当前节点的值是否为 7 ，若是则将该节点的值加入到结果列表 `res` 之中。

```java
/* 前序遍历 */
void perOrder(TreeNode root){
  if(root == null) return;
  if(root.val == 7) {
    //记录解
    res.add(root);
  }
  perOrder(root.left);
  perOrder(root.right);
}
例题二：**在二叉树中搜索所有值为** **7** **的节点，****返回根节点到这些节点的路径**
  res.add(new ArrayList<>(path));
//回退
	path.remove(path.size() - 1);
例题三：在二叉树中搜索所有值为7的节点，返回根节点到这些节点的路径，路径中不能包含值为3的节点
     // 剪枝
    if (root == null || root.val == 3) return;
```

框架代码

```java
/* 判断当前状态是否为解 */
boolean isSolution(List<TreeNode> state) {
    return !state.isEmpty() && state.get(state.size() - 1).val == 7;
}

/* 记录解 */
void recordSolution(List<TreeNode> state, List<List<TreeNode>> res) {
    res.add(new ArrayList<>(state));
}

/* 判断在当前状态下，该选择是否合法 */
boolean isValid(List<TreeNode> state, TreeNode choice) {
    return choice != null && choice.val != 3;
}

/* 更新状态 */
void makeChoice(List<TreeNode> state, TreeNode choice) {
    state.add(choice);
}

/* 恢复状态 */
void undoChoice(List<TreeNode> state, TreeNode choice) {
    state.remove(state.size() - 1);
}

/* 回溯算法 */
void backtrack(List<TreeNode> state, List<TreeNode> choices, List<List<TreeNode>> res) {
    // 检查是否为解
    if (isSolution(state)) {
        // 记录解
        recordSolution(state, res);
        return;
    }
    // 遍历所有选择
    for (TreeNode choice : choices) {
        // 剪枝：检查选择是否合法
        if (isValid(state, choice)) {
            // 尝试：做出选择，更新状态
            makeChoice(state, choice);
            backtrack(state, Arrays.asList(choice.left, choice.right), res);
            // 回退：撤销选择，恢复到之前的状态
            undoChoice(state, choice);
        }
    }
}

```

[17. 电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?company_slug=google)

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        
        // 创建一个 Map，用于将数字映射为字母。
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        
        // 调用回溯函数，生成所有的字母组合。

      backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        
        // 返回所有的字母组合。
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 如果已经到达了数字字符串的末尾，说明已经生成了一种完整的字母组合，将其加入到结果列表中。
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            // 如果还没有到达数字字符串的末尾，根据当前数字获取相应的字母集合，然后遍历字母集合，依次将每个字母添加到组合中，并进入下一层递归。
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 回溯到上一层递归时，需要将添加的字母删除，以便添加其他字母生成新的组合。
                combination.deleteCharAt(index);
            }
        }
    }
}


```



## 贪心算法

分发并饼干

```java
class Solution{
  public int findConnetntChildren(int[] g , int[] s){
    Arrays.sort(g);
    Arrays.sort(s);
    int start = 0;
    int count = 0;
    for(int i = 0; i < s.length && start < s.length; i++ ){
      if(s[i] >=g[start]){
        start++;
        counnt++;
      }
    }
    return 
  }
}
```



## 动态规划

### 杨辉三角

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // 创建一个用于存储杨辉三角的二维列表
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        // 循环生成每一行的数值
        for (int i = 0; i < numRows; ++i) {
            // 创建一个新的列表，用于存储当前行的数值
            List<Integer> row = new ArrayList<Integer>();
            
            // 循环生成当前行的每一个数值
            for (int j = 0; j <= i; ++j) {
                // 如果当前数值处于行首或行尾，则为1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 否则为上一行对应位置与其右侧位置之和
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            
            // 将当前行添加到二维列表中
            ret.add(row);
        }
        
        // 返回二维列表
        return ret;
    }
}

```

#### [509. 斐波那契数](https://leetcode.cn/problems/fibonacci-number/)

```java
class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q; 
            q = r; 
            r = p + q;
        }
        return r;
    }
}
O(n)
O(1)
```

#### [1137. 第 N 个泰波那契数](https://leetcode.cn/problems/n-th-tribonacci-number/)

```java
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int p = 0, q = 0, r = 1, s = 1;
        for (int i = 3; i <= n; ++i) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }
        return s;
    }
}

```

#### [198. 打家劫舍](https://leetcode.cn/problems/house-robber/)

```java
public int rob(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    // 子问题：
    // f(k) = 偷 [0..k) 房间中的最大金额

    // f(0) = 0
    // f(1) = nums[0]
    // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

    int N = nums.length;
    int[] dp = new int[N+1];
    dp[0] = 0;
    dp[1] = nums[0];
    for (int k = 2; k <= N; k++) {
        dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);
    }
    return dp[N];
}

//空间优化后
class Solution{
public int rob(int[] nums) {
    int prev = 0;
    int curr = 0;

    // 每次循环，计算“偷到当前房子为止的最大金额”
    for (int i : nums) {
        // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
        // dp[k] = max{ dp[k-1], dp[k-2] + i }
        int temp = Math.max(curr, prev + i);
        prev = curr;
        curr = temp;
        // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
    }

    return curr;
}
}
```

#### [740. 删除并获得点数](https://leetcode.cn/problems/delete-and-earn/

```java

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        int max = 0;
//用下标i表示原数组中的nums[i]，count[i]表示nums[i]的数量，并记录其最大值
        for (int num : nums) {
            count[num]++;
            max = Math.max(num, max);
        }
        
        int[] dp = new int[max + 1];
        dp[1] = count[1];
        for (int i = 2; i <= max; i++) {
             dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * (count[i]));
        }
        return dp[max];
    }
}

```

#### [322. 零钱兑换](https://leetcode.cn/problems/coin-change/)

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        memo[0] = 0;
        for(int i = 1; i <= amount;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < coins.length;j++){
                if(i - coins[j] >= 0 && memo[i-coins[j]] < min){
                    min = memo[i-coins[j]] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}
```

#### [63. 不同路径 II](https://leetcode.cn/problems/unique-paths-ii/)

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        
        // 定义 dp 数组并初始化第 1 行和第 1 列。
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

```

#### [120. 三角形最小路径和](https://leetcode.cn/problems/triangle/)

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

//空间优化
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

```



## 剑指offter

#### [剑指 Offer 06. 从尾到头打印链表](https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

```java
class Solution {
    public int[] reversePrint(ListNode head) {
        // 创建一个 LinkedList<Integer> 栈，用于保存节点值
        LinkedList<Integer> stack = new LinkedList<Integer>();
        // 循环遍历链表的每个节点，将节点的值添加到栈中
        while (head != null) {
            stack.addLast(head.val);  // 添加节点值到栈底
            head = head.next;  // 遍历下一个节点
        }
        // 创建一个 int 数组，用于存储栈中的元素
        int[] res = new int[stack.size()];
        // 遍历数组，并将栈中的元素逆序地添加到数组中
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();  // 将栈顶元素移除并添加到数组
        }
        // 返回该数组作为结果
        return res;
    }
}

```

### 剑指 Offer 09. 用两个栈实现队列

```java
class CQueue {
    LinkedList<Integer> A, B;
    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
  //添加元素
    public void appendTail(int value) {
        A.addLast(value);
    }
  //删除元素
    public int deleteHead() {
      //// 如果栈 B 不为空，直接弹出栈顶元素并返回
        if(!B.isEmpty()) return B.removeLast();
      //// 如果栈 A 和 B 都为空，返回 -1 表示队列中没有元素
        if(A.isEmpty()) return -1;
      //// 将栈 A 中的所有元素依次弹出并压入栈 B 中
        while(!A.isEmpty())
            B.addLast(A.removeLast());
      // 弹出栈 B 的栈顶元素并返回
        return B.removeLast();
    }
}


```

猜数字

```java
class Solution {
    public int game(int[] guess, int[] answer) {
        int tmp =0;
        for(int i = 0;i < guess.length;i++){
            if(guess[i] == answer[i]){
                tmp++;
            }
        }
        return tmp;
    }
}

```

## Google面试

### 匹配重复字符串

这是一个使用字符串匹配算法的题解。

首先，我们需要判断字符串 b 中是否有字符串 a 中不存在的字符。如果有，则直接返回 -1。

然后，我们计算出将字符串 a 重复叠加多少次可以使得其长度大于等于字符串 b 的长度。假设重复次数为 count。

我们使用 StringBuilder 类来重复叠加字符串 a，直到长度大于等于 b 的长度。在叠加之前，我们先使用 repeat 方法将字符串 a 重复 count 次。叠加完成后，我们循环将字符串 a 再次叠加，最多重复两次。在每次叠加之后，我们判断字符串 b 是否为新的字符串 a 的子串。如果是，则返回 count 加上叠加的次数。如果不是，则继续叠加。

如果循环结束后，字符串 b 仍然不是新的字符串 a 的子串，则说明无法通过重复叠加字符串 a 来得到字符串 b。此时，返回 -1。

注：在 Java 11 及以上版本中，可以使用 String 类的 repeat 方法来重复叠加字符串。如果使用 Java 10 及以下版本，则可以使用 StringBuilder 类的 append 方法。

```java
class Solution {
    public int repeatedStringMatch(String a, String b) {
        // 如果b里面有a不存在的字符，直接返回-1
        boolean[] arr = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            if (!arr[b.charAt(i) - 'a']) {
                return -1;
            }
        }

        int count = b.length() / a.length();
        StringBuilder sb = new StringBuilder(a.repeat(count));
        for (int i = 0; i <= 2; i++) {
            if (sb.indexOf(b) >= 0) {
                return count + i;
            }
            sb.append(a);
        }

        return -1;
    }
}
	O(n+m)
  O(n*[m/n])
```

### 最近时刻

```java
class Solution {
  public String nextClosestTime(String time) {
    List<String> memo = new ArrayList<>();  // 存储所有合理的事件
    char[] cs = time.toCharArray();
    Set<Character> set = new HashSet<>();

    List<String> hh = new ArrayList<>();    // 存储合理的小时部分
    List<String> mm = new ArrayList<>();    // 存储合理的分钟部分
    for(char c : cs){
        if(c != ':') set.add(c);
    }

    for(char c1: set){
        for(char c2: set){
            String str = ""+c1+c2;
            if(str.compareTo("24") < 0) hh.add(str);
            if(str.compareTo("60") < 0) mm.add(str);
        }
    }

    // 拼接小时与分钟部分
    for(String h : hh){
        for(String m : mm){
            memo.add(h + ":" +m);
        }
    }


    Collections.sort(memo);         // 排序
    int idx = memo.indexOf(time);   // 获取当前索引
    // 如果当前值在最后一个,返回第一个; 否则返回下一个
    if( idx == memo.size()-1) return memo.get(0);
    else return memo.get(idx+1);
  }
}
```

第二种方法，最优化后

```java
class Solution {
    /**
     * Given a string representing a time in the format "HH:MM",
     * find the next closest time by reusing the current digits.
     * If the next closest time is on the next day,
     * return the smallest possible time on the next day.
     *
     * @param time time a string representing a time in the format "HH:MM"
     * @return the next closest time in the same format "HaH:MM"
     */
    public String nextClosestTime(String time) {
        // Use an array of length 4 to represent the time,
        // e.g., [1,2,3,4] represents 12:34.
        int[] nums = new int[4]; // 使用一个长度为4的数组来记录时间，比如[1,2,3,4]代表12:34。
        char[] chars = time.toCharArray();
        int index = 0;

        // 将字符串解析成数字，并将时间放到nums数组当中
        // Parse the string into an integer array and put the time into the nums array
        for (int i = 0; i < chars.length; i++) {
            if (i == 2) continue; // Skip the colon character
            nums[index] = chars[i] - '0';
            index++;
        }

        // 找出nums数组当中的最小值，留作后面使用
        // Find the smallest number in nums for later use
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minNum = Math.min(minNum, nums[i]);
        }

        // Use a variable to record whether the closest time has been found or not
        boolean found = false; // 使用一个变量来记录是否找到了最近时刻
        // Iterate through the nums array from the end to the beginning,
        // because changing the time at the end will result in the smallest change in time.
        for (int i = nums.length - 1; i >= 0; i--) { // 从后向前遍历数据，因为改动后面的时间一定比改动前面的时间变动更小
            int largerNum = Integer.MAX_VALUE;
            // Find the smallest number larger than the current digit in nums,
            // which will be used to replace the current digit to make the time as close as possible
            for (int j = 0; j < nums.length; j++) { // 使用一个循环来找到nums中比当前数字大的所有数里最小的一个，使用它来替代当前数字时间变动一定最小
                if (nums[j] > nums[i]) {
                    largerNum = Math.min(largerNum, nums[j]);
                }
            }

            if (largerNum != Integer.MAX_VALUE) {
                int temp = nums[i];
                nums[i] = largerNum;
                // Check if the new time is valid, if not, revert to the original data and continue iterating the previous digit
                // If the new time is valid, then all subsequent digits should be set to the minimum value in nums,
                // corresponding to the situation where the time is closest but still earlier than the current time, such as 12:33, which is closer to 12:34 than 13:33.
                if (isValid(nums)) { // 判断变动之后数据是否合法，如果不合适则恢复原数据，然后继续遍历前一位
                    // 如果当前数据变动合法，那么应该从当前数据的位置继续向后遍历，将每一位赋值成nums数组当中的最小值
                    // 对应情况12:33，如果只是将时间变成13:33并不是最近时刻，因为13:11才是最近时刻
                    for (int j = i + 1; j < nums.length; j++) {
                        nums[j] = minNum;
                    }
                    found = true;
                    break;
                } else nums[i] = temp;
            }
        }
        // If the closest time cannot be found,
        // then the closest time is the smallest possible time on the next day,
        // which is all digits set to the minimum value in nums.
        if (!found) { // 如果没有找到最近时间，那么最近时间就是第2天的最小时间，将所有值都赋值成最小值即可
            for (int i = 0; i < nums.length; i++) {
                nums[i] = minNum;
            }
        }
        StringBuilder builder = new StringBuilder();
        // 拼装最后的结果
        // Concatenate the final result
        for (int i = 0; i < nums.length; i++) {
            builder.append(nums[i]);
            // Insert the colon between the hours and minutes
            if (i == 1) builder.append(":");
        }
        return builder.toString();
    }

    /**
     * 定义一个方法用于判断时间是否有效。
     * 当nums[0]大于2，或者nums[0]等于2时nums[1]大于3，或者 nums[2]大于5，这三种情况下时间无效。
     * 其他情况下时间都是有效值。
     **/
    boolean isValid(int[] nums) {
        if (nums[0] > 2 || (nums[0] == 2 && nums[1] > 3) || nums[2] > 5) return false;
        return true;
    }

}
```



### 最长同值路径

```java
class Solution {
    int res;

    public int longestUnivaluePath(TreeNode root) {
        // 初始化最长同值路径长度为0
        res = 0;
        // 递归遍历二叉树
        dfs(root);
        // 返回最长同值路径长度
        return res;
    }

    public int dfs(TreeNode root) {
        // 如果节点为空，返回0
        if (root == null) {
            return 0;
        }
        // 递归遍历左右子树
        int left = dfs(root.left), right = dfs(root.right);
        // 初始化左右子树中包含当前节点的同值路径长度为0
        int left1 = 0, right1 = 0;
        // 如果当前节点的左子节点值等于当前节点值，更新左子树的同值路径长度
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        // 如果当前节点的右子节点值等于当前节点值，更新右子树的同值路径长度
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        // 更新最长同值路径长度
        res = Math.max(res, left1 + right1);
        // 返回左右子树中包含当前节点的同值路径长度的最大值
        return Math.max(left1, right1);
    }
}

```

### 密钥格式化

```java
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder ans = new StringBuilder(); //用来存储新字符串的StringBuilder对象
        int cnt = 0; //计数器，用来确定何时添加破折号

        // 从原字符串的最后一位开始遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') { //如果当前字符不是破折号
                cnt++; //增加计数器
                ans.append(Character.toUpperCase(s.charAt(i))); //将字符转换为大写并添加到新字符串中
                if (cnt % k == 0) { //如果已经添加了k个字符
                    ans.append("-"); //添加一个破折号
                }
            }
        }

        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') { //如果新字符串的最后一位是破折号
            ans.deleteCharAt(ans.length() - 1); //删除它
        }

        return ans.reverse().toString(); //将新字符串反转并返回
    }
}


```

思路： 这个题目要求我们把一个包含破折号的字符串转化为一定数量k的字符为一组的字符串，并用破折号分割。首先，我们需要遍历字符串并将其中的字符转换为大写，然后每k个字符添加一个破折号。最后，需要把字符串反转过来，并且如果最后一个字符是破折号则要删除它。

优化： 我们可以使用StringBuilder来构建字符串，因为它比String对象更高效。我们也可以使用字符数组来存储新的字符串，这将进一步提高性能。

时间复杂度： 该算法需要遍历原字符串一次，时间复杂度为O(n)，其中n是原字符串的长度。在遍历字符串的过程中，可能需要将每个字符转换为大写并添加到新字符串中，这需要O(1)的时间。因此，总的时间复杂度为O(n)。

空间复杂度： 在算法中，我们使用了一个StringBuilder对象来存储新字符串，因此空间复杂度是O(n)，其中n是原字符串的长度。另外，我们还需要使用一个计数器来跟踪添加了多少个字符，以便在每k个字符后添加一个破折号。由于k是一个常数，因此计数器的空间复杂度是O(1)。因此，总的空间复杂度是O(n)。



```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}

```

## 数组和字符串

#### [54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/)

```java
class Solution{
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>(); // 用于存放结果的List
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return result; // 对于空矩阵，直接返回空结果
    }
    int m = matrix.length, n = matrix[0].length; // 获取矩阵的行数和列数
    int left = 0, right = n - 1, top = 0, bottom = m - 1; // 定义当前的上、下、左、右四个边界
    while (left <= right && top <= bottom) { // 只有在上、下、左、右四个边界没有相遇时才进行遍历
        // 从左到右遍历当前层
        for (int j = left; j <= right; j++) {
            result.add(matrix[top][j]); // 将遍历到的元素添加到结果List中
        }
        top++; // 更新上边界
        // 从上到下遍历当前层
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]); // 将遍历到的元素添加到结果List中
        }
        right--; // 更新右边界
        if (top <= bottom) { // 如果上、下边界还没有相遇，继续遍历
            // 从右到左遍历当前层
            for (int j = right; j >= left; j--) {
                result.add(matrix[bottom][j]); // 将遍历到的元素添加到结果List中
            }
            bottom--; // 更新下边界
        }
        if (left <= right) { // 如果左、右边界还没有相遇，继续遍历
            // 从下到上遍历当前层
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]); // 将遍历到的元素添加到结果List中
            }
            left++; // 更新左边界
        }
    }
    return result; // 返回最终的结果List
	}
}

```

第二种使用递归算法

```java
/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        spiralOrderHelper(matrix, left, right, top, bottom, res);
        return res;
    }

    // 递归函数，遍历矩阵中的元素并添加到结果列表中
    private void spiralOrderHelper(int[][] matrix, int left, int right, int top, int bottom, List<Integer> res) {
        if (left > right || top > bottom) { // 判断边界是否相遇，如果相遇，则遍历完矩阵中的所有元素，返回
            return;
        }
        // 遍历矩阵最上面一行
        for (int j = left; j <= right; j++) {
            res.add(matrix[top][j]);
        }
        // 遍历矩阵最右边一列
        for (int i = top + 1; i <= bottom; i++) {
            res.add(matrix[i][right]);
        }
        if (left < right && top < bottom) { // 判断是否需要继续遍历，如果已经到达了最里面一圈，则不需要再次遍历
            // 遍历矩阵最下面一行
            for (int j = right - 1; j >= left; j--) {
                res.add(matrix[bottom][j]);
            }
            // 遍历矩阵最左边一列
            for (int i = bottom - 1; i > top; i--) {
                res.add(matrix[i][left]);
            }
        }
        // 继续遍历矩阵中心的一圈
        spiralOrderHelper(matrix, left + 1, right - 1, top + 1, bottom - 1, res);
    }
}

```

#### 66.加1

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}	
```

#### 42.接雨水（困难）

用栈

```java
public int trap6(int[] height) {
    int sum = 0;
    Stack<Integer> stack = new Stack<>();
    int current = 0;
    while (current < height.length) {
        //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
        while (!stack.empty() && height[current] > height[stack.peek()]) {
            int h = height[stack.peek()]; //取出要出栈的元素
            stack.pop(); //出栈
            if (stack.empty()) { // 栈空就出去
                break; 
            }
            int distance = current - stack.peek() - 1; //两堵墙之前的距离。
            int min = Math.min(height[stack.peek()], height[current]);
            sum = sum + distance * (min - h);
        }
        stack.push(current); //当前指向的墙入栈
        current++; //指针后移
    }
    return sum;
}

```

建议用动态规划（目前不会用）

#### [159. 至多包含两个不同字符的最长子串](https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/)

#### 滑动窗口

```java
	class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int n = s.length();
    if (n < 3) return n;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    // hashmap character -> its rightmost position 
    // in the sliding window
    HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

    int max_len = 2;

    while (right < n) {
      // slidewindow contains less than 3 characters
      if (hashmap.size() < 3)
        hashmap.put(s.charAt(right), right++);

      // slidewindow contains 3 characters
      if (hashmap.size() == 3) {
        // delete the leftmost character
        int del_idx = Collections.min(hashmap.values());
        hashmap.remove(s.charAt(del_idx));
        // move left pointer of the slidewindow
        left = del_idx + 1;
      }

      max_len = Math.max(max_len, right - left);
    }
    return max_len;
  }
}

```



#### [340. 至多包含 K 个不同字符的最长子串](https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/)

#### 滑动窗口 + 哈希表

```java
class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();
    if (n*k == 0) return 0;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    // hashmap character -> its rightmost position 
    // in the sliding window
    LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);

    int max_len = 1;

    while (right < n) {
      Character character = s.charAt(right);
      // if character is already in the hashmap -
      // delete it, so that after insert it becomes
      // the rightmost element in the hashmap
      if (hashmap.containsKey(character))
        hashmap.remove(character);
      hashmap.put(character, right++);

      // slidewindow contains k + 1 characters
      if (hashmap.size() == k + 1) {
        // delete the leftmost character
        Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
        hashmap.remove(leftmost.getKey());
        // move left pointer of the slidewindow
        left = leftmost.getValue() + 1;
      }

      max_len = Math.max(max_len, right - left);
    }
    return max_len;
  }
}

```

### 给字符串添加家粗标签

枚举

```java
class Solution {
        public String addBoldTag(String S, String[] words) {
            // Create a boolean array with the same length as string S to indicate whether each character is bold or not.
            boolean[] tempS = new boolean[S.length()];

            // Iterate through each word in the array of words to be bolded.
            for (String word : words) {
                // Find the starting index of the current word in string S.
                int i = S.indexOf(word);
                // Get the length of the current word.
                int size = word.length();
                // Continue to search for the current word in S until all instances of the word have been found.
                while (i != -1) {
                    // Mark each character in the word as bold in the tempS array.
                    for (int j = i; j < i + size; j++)
                        tempS[j] = true;

                    // Continue searching for the word after the current instance.
                    i = S.indexOf(word, i + 1);
                }
            }

            // Construct the final string with bold tags added to the appropriate characters.
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < tempS.length; ) {
                // If the current character is bold, add the opening bold tag and all subsequent bold characters until
                // reaching the end of the bold section, then add the closing bold tag.
                if (tempS[i]) {
                    sb.append("<b>");
                    while (i < tempS.length && tempS[i]) {
                        sb.append(S.charAt(i));
                        i++;
                    }
                    sb.append("</b>");
                }
                // If the current character is not bold, simply add it to the string.
                else {
                    sb.append(S.charAt(i));
                    i++;
                }
            }
            return sb.toString();
        }
}


```

### 生命游戏

```java
/**
     * 为了保证当前修改后的状态不会影响下一个状态的判定，设置另外的状态
     * 如题所示，只有三种：
     * 1. 如果当前是活细胞，但是变成了死细胞，那么设置为-1
     * 2. 如果当前是活细胞，仍然是活细胞，那么不变仍为1
     * 3. 如果当前是死细胞，但是变成了活细胞，那么设置为2
     * 那么最后遍历修改完状态之后，将-1修改回为0，2修改回为1
     * @param board
     */
    public void gameOfLife(int[][] board) {
        //设置方向来遍历某个节点周围的另外几个节点
        int[] ner = new int[]{-1,0,1};
        //获取行和列
        int rows  = board.length;
        int cols = board[0].length;
        //遍历每一个节点格子
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //设置当前节点周围的存活细胞的数量
                int liveNer = 0;
                /**
                 * 当前节点是[ i , j ]
                 * [i-1,j-1]    [i-1,j]    [i-1,j+1]
                 * [ i ,j-1]    [ i ,j]    [ i ,j+1]
                 * [i+1,j-1]    [i+1,j]    [i+1,j+1]
                 * 那么以当前节点为中心，要求周围的节点，则最多是3*3形式
                 * 并且所有的行和列都是用当前节点+1或者-1或者不变构成
                 * 所以我们设置 ner = {-1,0,1} 来形成遍历
                 */
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        //必须保证不计算当前节点(不计算自己)
                        if (!(ner[i]==0 && ner[j]==0)){
                            //当前节点的相邻节点坐标
                            int r = row+ner[i];
                            int c = col+ner[j];
                            /**判断当前周围节点的存活状态，要求满足两个状态
                             * 1. 必须保证要在 board 矩阵中
                             * 2. 并且起始状态要是存活，则当前状态为1或者-1都可以(因为这两个状态都表示起始状态为活细胞)
                             **/
                            if ((r>=0&&r<rows) && (c>=0&&c<cols) && (Math.abs(board[r][c])==1)){
                                liveNer++;
                            }
                        }
                    }
                }
                /**开始判断当前节点的存活状态
                 * 因为遍历到当前节点的时候，还没有开始修改细胞状态，所以还是0和1的细胞状态
                 * 那么只需要判断状态变化的即可，否则状态不变
                **/
                if ((board[row][col]==1) && ( liveNer>3 || liveNer<2)){
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col]=-1;
                }
                if (board[row][col]==0 && ( liveNer==3)){
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col]=2;
                }
            }
        }
        //再把额外的状态修改回去
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
                if (board[row][col] == -1){
                    board[row][col] = 0;
                }
            }
        }
    }
```

### 406。根据身高重建队列

```java
    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先H高度降序，K个数升序排序
     * 2.遍历排序后的数组，根据K插入到K的位置上
     *
     * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }	

        return list.toArray(new int[list.size()][2]);
    }


```

### 离建筑物最近的距离

```java
class Solution{
  private int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0} };
}
public int shortestDistance(int[][] grid){
  int m = grid.length;
  if(m == 0){
    return 0;
  }
  int n = grid[0].length;
  int[][] totalDist = new int[m][n];
  int res = Integer.MAX_VALUE;
  int mark = 0;
  for(int i = 0 ; i < m;i++){
    for(int j = 0 ; j < n; i++){
      if(grid[i][j] ==1){
        res = bfs(grid,m ,n,i,j,amrk,totalDist);
        mark--;
      }
    }
  }
 	 return res;
}
private int bfs(int[][]grid,int m ,int n, int i ,int j int mark,int[][] totalDist){
  int res = Integer.MAX_VALUE;
  Queue<int[]> queue = new LinkedList<>();
}
```

#### [324. 摆动排序 II](https://leetcode.cn/problems/wiggle-sort-ii/)

```java
class Solution {
    public void wiggleSort(int[] nums) {
        // 将原数组复制一份并进行排序
        int[] arr = nums.clone();
        Arrays.sort(arr);
        
        int n = nums.length;
        // x 为新数组中奇数索引的个数
        int x = (n + 1) / 2;
        
        // 从头到尾遍历原数组，每次将新数组中 j 位置的元素放到 nums 中 i 位置上，
        // 将新数组中 k 位置的元素放到 nums 中 i+1 位置上
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }
}
 
```

#### [8. 字符串转换整数 (atoi)](https://leetcode.cn/problems/string-to-integer-atoi/)

```java
public class Solution {

    public int myAtoi(String str) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "2147483646";
        int res = solution.myAtoi(str);
        System.out.println(res);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}

```

#### [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/)

双指针

```java
class Solution{
  public int maxArea(int[] height){
    int i = 0 ; j = height.length - 1,res = 0;
    while(i < j){
      res = height[i] < height[j]?
        Math.max(res,[j - i] * height[i++]):
      	Math.max(res,[j - i] * height(j--));
    }
    return res;
  }
}
```

#### [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums, target + 1);
        return l == r ? new int[] {-1, -1} : new int[] {l, r - 1};
    }

    private int search(int[] nums, int x) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

//第二种简单
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target); // 选择其中一种写法即可
        if (start == nums.length || nums[start] != target)
            return new int[]{-1, -1};
        // 如果 start 存在，那么 end 必定存在
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    // lowerBound 返回最小的满足 nums[i] >= target 的 i
    // 如果数组为空，或者所有数都 < target，则返回 nums.length
    // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]

    // 闭区间写法
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 闭区间 [left, right]
        while (left <= right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right+1] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1; // 范围缩小到 [mid+1, right]
            else
                right = mid - 1; // 范围缩小到 [left, mid-1]
        }
        return left; // 或者 right+1
    }

    // 左闭右开区间写法
    private int lowerBound2(int[] nums, int target) {
        int left = 0, right = nums.length; // 左闭右开区间 [left, right)
        while (left < right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1; // 范围缩小到 [mid+1, right)
            else
                right = mid; // 范围缩小到 [left, mid)
        }
        return left; // 或者 right
    }

    // 开区间写法
    private int lowerBound3(int[] nums, int target) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right; // 或者 left+1
    }
}
O(longn)
O(1)
 
```

#### [1870. 准时到达的列车最小时速](https://leetcode.cn/problems/minimum-speed-to-arrive-on-time)

```java
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > Math.ceil(hour)) return -1;
        // 搜索边界
        int left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果以 mid 速度可达，那么就尝试减小速度
            if (check(dist, hour, mid)) right = mid;
            // 否则就需要加了
            else left = mid + 1;
        } 
        return left;
    }

    private boolean check(int[] dist, double hour, int speed) {
        double cnt = 0.0;
        // 对除了最后一个站点以外的时间进行向上取整累加
        for (int i = 0; i < dist.length - 1; ++i) {
            // 除法的向上取整
            cnt += (dist[i] + speed - 1) / speed;
        }
        // 加上最后一个站点所需的时间
        cnt += (double) dist[dist.length - 1] / speed;
        return cnt <= hour;
    }
}


```

#### [1894. 找到需要补充粉笔的学生编号](https://leetcode.cn/problems/find-the-student-that-will-replace-the-chalk/)

```java
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            preSum[i + 1] = preSum[i] + chalk[i]; // 计算前缀和数组
        }
        k %= preSum[n]; // 对 k 取模，防止 k 太大导致整型溢出
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1; // 二分查找
            if (preSum[mid + 1] > k) { // 如果当前位置的前缀和大于 k，说明 k 落在前半段
                right = mid;
            } else { // 否则 k 落在后半段
                left = mid + 1;
            }
        }
        return left; // 返回找到的下标
    }
}
时间复杂度：该算法只进行了一次遍历和一次二分查找，因此时间复杂度为 O(log n)。

空间复杂度：该算法使用了一个额外的前缀和数组，因此空间复杂度为 O(n)。
```

#### [1898. 可移除字符的最大数目](https://leetcode.cn/problems/maximum-number-of-removable-characters/)

```java
class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0, right = removable.length;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(s, p, removable, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(String s, String p, int[] removable, int mid) {
        int m = s.length(), n = p.length(), i = 0, j = 0;
        Set<Integer> ids = new HashSet<>();
        for (int k = 0; k < mid; ++k) {
            ids.add(removable[k]);
        }
        while (i < m && j < n) {
            if (!ids.contains(i) && s.charAt(i) == p.charAt(j)) {
                ++j;
            }
            ++i;
        }
        return j == n;
    }
}

```



#### [面试题 17.22. 单词转换](https://leetcode.cn/problems/word-transformer-lcci/)

```java
class Solution {
      public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        //定义BFS的队列
        Queue<String> queue = new LinkedList<String>();
        //ans存放答案
        List<String> ans = new LinkedList<String>();
        //标记是否被访问过
        boolean[] visited = new boolean[wordList.size()];
        //存放每个单词的前驱，比如hot的前驱可以是hit,lot等；
        HashMap<String,String> map = new HashMap<String,String>();
        //初步判断
        if(!wordList.contains(endWord)){
            return ans;
        }
        //将第一个单词加入队列
        queue.add(beginWord);
        boolean flag = false;
        //BFS主要操作
        while(queue.size() != 0){
            //先将头取出
            String queueHead = queue.poll();
            //如果队列头元素等于endword，代表已经找到，break同时设置flag = true;
            if(queueHead.equals(endWord)){
                flag = true;			
                break;
            }
            //寻找可能的元素加入队列，并且设置对应的前驱。
            for(int i = 0;i < wordList.size();i ++){
                //如果未被访问过并且可以直接转换，则加入队列，compare()函数用来判断是否可以转换。
                if(visited[i] == false && compare(wordList.get(i),queueHead) == true){
                    queue.add(wordList.get(i));
                    visited[i] = true;
                    //存储前驱
                    map.put(wordList.get(i), queueHead);
                }
            }
        }
        if(flag == false){
            return ans;
        } 

        //遍历答案
        String key = endWord;
        while(map.get(key) != beginWord){
            ans.add(key);
            key = map.get(key);
        }
        ans.add(key);
        ans.add(map.get(key));
        Collections.reverse(ans);
        return ans;
    }
    public static boolean compare(String word1,String word2){
        int diff = 0;
        for(int i = 0;i < word1.length();i ++){
            if(word1.charAt(i) != word2.charAt(i)){
                diff ++;
                if(diff >= 2){
                    return false;
                }
            }
        }
        return true;
    }
}

```

#### [面试题 17.16. 按摩师](https://leetcode.cn/problems/the-masseuse-lcci/)

```java
class Solution {
    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp0 = 0, dp1 = nums[0];

        for (int i = 1; i < n; ++i){
            int tdp0 = Math.max(dp0, dp1); // 计算 dp[i][0]
            int tdp1 = dp0 + nums[i]; // 计算 dp[i][1]

            dp0 = tdp0; // 用 dp[i][0] 更新 dp_0
            dp1 = tdp1; // 用 dp[i][1] 更新 dp_1
        }
        return Math.max(dp0, dp1);
    }
}

```

动态规划题目：

#### [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/)

```java
public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
```

#### [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/)

```java
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
			return true;
		}
		if (nums[0] == 0) {
			return false;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0] ;
		for (int i = 1; i < nums.length; i++) {
			// 前一位置还有剩余步数走到下一位置
			if (dp[i - 1] < 1){
				return false;
			}
		
			dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
			//当前位置剩余步数是负数，则说明不可达，直接返回，此后的位置也都不可达。
			if (dp[i] < 0) {
				return false;
			}
		}
		return true;
    }
}

```

#### [62. 不同路径](https://leetcode.cn/problems/unique-paths/)

```java
class Solution {
    public int uniquePaths(int m, int n) {
        // 初始化 f 数组
        int[][] f = new int[m][n];
        // 第一列的所有位置只有一种走法
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        // 第一行的所有位置只有一种走法
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        // 从 (1,1) 开始填充 f 数组，每个位置的值为到达该位置的不同路径数
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        // 返回到达右下角位置的路径数
        return f[m - 1][n - 1];
    }
}

o	(mn)
o(mn)
```

#### [64. 最小路径和](https://leetcode.cn/problems/minimum-path-sum/)

```java
class Solution {
    public int minPathSum(int[][] grid) {
        // 遍历二维数组，计算到达每个位置的最小路径和
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue; // 左上角位置无需计算
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j]; // 第一行位置只能从左边到达
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j]; // 第一列位置只能从上面到达
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]; // 其他位置可以从左边或上面到达，选择最小值
            }
        }
        // 返回右下角位置的最小路径和
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

```

#### [309. 最佳买卖股票时机含冷冻期](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
      	// f0: 手上持有股票的最大收益
        // f1: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f2: 手上不持有股票，并且不在冷冻期中的累计最大收益

        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
    }
}
O(n)
O(n)
```

#### [121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/)

```java
//暴力法
public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
O(n)
O(1) 
  
  
 //动态规划
 
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}

O(N)
O(N)
  
```

#### [LCP 07. 传递信息](https://leetcode.cn/problems/chuan-di-xin-xi/)

```java
class Solution {
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }
}

//空间复杂度优化后
class Solution{
  public int numWays(int n, int[][] relation, int k) {
    int[] dp = new int[n];
    dp[0] = 1;
    for(int i = 0; i < k;i++){
      int[] next = new int[n];
      for(int[] edge : relation){
        int src = edge[0];
        int dst = edge[1];
        next[dst] += dp[src];
      }
      dp = next;
    }
      return dp[n - 1];
    }
  }

O(km)
  O(n)
```

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
    }
}


//空间复杂度优化后
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 2], cost[i - 1]) + cost[i];
        }
        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }
}
 
```

#### [剑指 Offer II 088. 爬楼梯的最少成本](https://leetcode.cn/problems/GzCJIP/)

```java

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 2];
        dp[n] = 0;
        dp[n + 1] = 0; 
        for(int i = n - 1; i >= 0; --i){
            int p1 = cost[i] + dp[i + 1];
            int p2 = cost[i] + dp[i + 2];
            dp[i] = Math.min(p1,p2);
        }
        return Math.min(dp[0],dp[1]);
    }
}
```

```java
class Solution {
    public boolean divisorGame(int n) {
        boolean[] f = new boolean[n + 5];

        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[n];
    }
}	 
```

#### [605. 种花问题](https://leetcode.cn/problems/can-place-flowers/)

贪心算法

```java
public boolean canPlaceFlowers(int[] flowerbed, int n) {
    // 遍历花坛数组，直到花坛末尾或者所有需要种植的花已经种植完毕
    for (int i = 0, len = flowerbed.length; i < len && n > 0;) {
        if (flowerbed[i] == 1) {
            // 如果当前位置已经种植了花，跳过下一个位置
            i += 2;
        } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
            // 如果当前位置为空地并且下一个位置也是空地或者已经种植了花，则在当前位置种植花
            n--;
            i += 2;
        } else {
            // 如果当前位置为空地但是下一个位置也是空地，则跳过下两个位置
            i += 3;
        }
    }
    // 如果所有需要种植的花都已经成功种植，则返回true；否则返回false
    return n <= 0;
}

```

```java
String removeDuplicateLetters(String s) {
    // 存放去重的结果
    Stack<Character> stk = new Stack<>();
    // 布尔数组初始值为 false，记录栈中是否存在某个字符
    // 输入字符均为 ASCII 字符，所以大小 256 够用了
    boolean[] inStack = new boolean[256];

    for (char c : s.toCharArray()) {
        // 如果字符 c 存在栈中，直接跳过
        if (inStack[c]) continue;
        // 若不存在，则插入栈顶并标记为存在
        stk.push(c);
        inStack[c] = true;
    }

    StringBuilder sb = new StringBuilder();
    while (!stk.empty()) {
        sb.append(stk.pop());
    }
    // 栈中元素插入顺序是反的，需要 reverse 一下
    return sb.reverse().toString();
}


```

```java
class Solution {
    List<Integer> list;
    Random random;

    public Solution(ListNode head) {
        list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    
```

#### [229. 多数元素 II](https://leetcode.cn/problems/majority-element-ii/)

```java
//哈希表算法
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
          //containsKey方法——判断是否包含指定的键名
            if (cnt.containsKey(nums[i])) {
                cnt.put(nums[i], cnt.get(nums[i]) + 1);
            } else {
                cnt.put(nums[i], 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int x : cnt.keySet()) {
            if (cnt.get(x) > nums.length / 3) {
                ans.add(x);
            }
        }
   
        return ans;
    }
}

```

#### [13. 罗马数字转整数](https://leetcode.cn/problems/roman-to-integer/)

```java
class Solution {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}

```

#### [58. 最后一个单词的长度](https://leetcode.cn/problems/length-of-last-word/)

```java

//从右向左遍历，从第一个不是空格的字符开始计数，一旦开始计数，再遇到空格就结束了
class Solution {
    public int lengthOfLastWord(String s) {
         if(s == null || s.length() == 0) return 0;
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(count == 0) continue;
                break;
            }
            count++;
        }
        return count;        
    }
}

```

#### [66. 加一](https://leetcode.cn/problems/plus-one/)

```java

//数组遍历
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}

```

#### [1. 两数之和](https://leetcode.cn/problems/two-sum/)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

```

#### [190. 颠倒二进制位](https://leetcode.cn/problems/reverse-bits/)

```java
class Solution {
private:
    const uint32_t M1 = 0x55555555; // 01010101010101010101010101010101
    const uint32_t M2 = 0x33333333; // 00110011001100110011001100110011
    const uint32_t M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    const uint32_t M8 = 0x00ff00ff; // 00000000111111110000000011111111

public:
    uint32_t reverseBits(uint32_t n) {
        n = n >> 1 & M1 | (n & M1) << 1;
        n = n >> 2 & M2 | (n & M2) << 2;
        n = n >> 4 & M4 | (n & M4) << 4;
        n = n >> 8 & M8 | (n & M8) << 8;
        return n >> 16 | n << 16;
    }
};

```

#### [1507. 转变日期格式](https://leetcode.cn/problems/reformat-date/)

```java
class Solution {
    public String reformatDate(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> s2month = new HashMap<String, Integer>();
        for (int i = 1; i <= 12; i++) {
            s2month.put(months[i - 1], i);
        }
        String[] array = date.split(" ");
        int year = Integer.parseInt(array[2]);
        int month = s2month.get(array[1]);
        int day = Integer.parseInt(array[0].substring(0, array[0].length() - 2));
        return String.format("%d-%02d-%02d", year, month, day);
    }
}

```

#### [1539. 第 k 个缺失的正整数](https://leetcode.cn/problems/kth-missing-positive-number/)

```java 
//枚举
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missCount = 0, lastMiss = -1, current = 1, ptr = 0; 
        for (missCount = 0; missCount < k; ++current) {
            if (current == arr[ptr]) {
                ptr = (ptr + 1 < arr.length) ? ptr + 1 : ptr;
            } else {
                ++missCount;
                lastMiss = current;
            }
        }
        return lastMiss;
    }
}
//二分查找
class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
  
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
            if (x - mid - 1 >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
    }
}

```

#### [46. 全排列](https://leetcode.cn/problems/permutations/

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // 将数组转换为列表形式
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        // 回溯求解所有的排列组合
        backtrack(n, output, res, 0);
        return res;
    }

    // 回溯函数，用于求解所有排列组合
    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 如果已经填完了所有数，将当前结果添加到结果列表中
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        // 从第一个位置开始，依次将当前位置和后面的位置进行交换
        for (int i = first; i < n; i++) {
            // 动态维护数组，将第一个位置和第 i 个位置的元素交换
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作，将第一个位置和第 i 个位置的元素交换回来
            Collections.swap(output, first, i);
        }
    }
}

```

#### [202. 快乐数](https://leetcode.cn/problems/happy-number/)

```java
//哈希表算法
class Solution {
    //定义一个函数，用于计算给定数字的下一个数字
    private int getNext(int n) {
        int totalSum = 0;
        //将n拆分成各个位数，计算各位数的平方和
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        //返回计算结果
        return totalSum;
    }

    //定义一个函数，用于判断一个数字是否是快乐数
    public boolean isHappy(int n) {
        //创建一个哈希集合，用于存储之前遇到过的数字
        Set<Integer> seen = new HashSet<>();
        //如果n不是1且在seen中还没有出现过，就继续执行循环
        while (n != 1 && !seen.contains(n)) {
            //将当前数字加入seen中
            seen.add(n);
            //将当前数字更新为下一个数字
            n = getNext(n);
        }
        //如果n最终等于1，说明这是一个快乐数，返回true
        //否则说明这不是一个快乐数，返回false
        return n == 1;
    }
}

```

#### [217. 存在重复元素](https://leetcode.cn/problems/contains-duplicate/)

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1 ; i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}


```

[528. 按权重随机选择](https://leetcode.cn/problems/random-pick-with-weight/?company_slug=google)

```java
class Solution {
    int[] pre; // 前缀和数组，pre[i] 存储前 i 个元素的和
    int total; // 所有元素的和
    
    // 构造函数，计算前缀和数组和所有元素的和
    public Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            pre[i] = pre[i - 1] + w[i];
        }
        total = Arrays.stream(w).sum(); // 计算所有元素的和
    }
    
    // 随机选择一个元素并返回它的索引
    public int pickIndex() {
        int x = (int) (Math.random() * total) + 1; // 随机生成一个 1 到总和之间的数字
        return binarySearch(x); // 二分查找在前缀和数组中第一个大于等于 x 的位置，并返回该位置
    }

    // 二分查找，在前缀和数组中找到第一个大于等于 x 的位置
    private int binarySearch(int x) {
        int low = 0, high = pre.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (pre[mid] < x) { // 如果当前位置的前缀和小于 x，则往右侧寻找
                low = mid + 1;
            } else { // 如果当前位置的前缀和大于等于 x，则往左侧寻找
                high = mid;
            }
        }
        return low; // 返回最终找到的位置
    }
}

```

#### [1528. 重新排列字符串](https://leetcode.cn/problems/shuffle-string/)

```java
class Solution {
    public String restoreString(String s, int[] indices) {
        int length = s.length();
        char[] result = new char[length];

        for (int i = 0; i < length; i++) {
            result[indices[i]] = s.charAt(i);
        }
        return new String(result);
    }
}

```

```java
方法一：哈希映射
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int x : arr) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (key == value) {
                ans = Math.max(ans, key);
            }
        }
        return ans;
    }	
}
 O(n)
 0(n)
```

394. 字符串解码](https://leetcode.cn/problems/decode-string/?company_slug=google)

```java
/**

根据题意，使用栈来维护每个字符的出现次数和对应的子串
遍历字符串s，对于每个字符c，分为以下情况：
若c为数字，则更新当前数字multi；
若c为'['，则将当前ans和multi分别压入栈ansStack和multiStack中，并将ans重置为空串，multi重置为0；
若c为字母，则将其添加到ans中；
若c为']'，则弹出栈顶的ans和multi，将ans重复multi次并添加到ansTmp中，将ans更新为ansTmp。
最后返回ans即为所求。
*/

class Solution {
     public String decodeString(String s) {
		StringBuffer ans=new StringBuffer();
		Stack<Integer> multiStack=new Stack<>();  //多堆栈
		Stack<StringBuffer> ansStack=new Stack<>();
		int multi=0;
		for(char c:s.toCharArray()){
			if(Character.isDigit(c))multi=multi*10+c-'0';
			else if(c=='['){
				ansStack.add(ans);
				multiStack.add(multi);
				ans=new StringBuffer();
				multi=0;
			}else if(Character.isAlphabetic(c)){
				ans.append(c);
			}else{
				StringBuffer ansTmp=ansStack.pop();
				int tmp=multiStack.pop();
				for(int i=0;i<tmp;i++)ansTmp.append(ans);
				ans=ansTmp;
			}
		}
		return ans.toString();
	}
}
```

[424. 替换后的最长重复字符](https://leetcode.cn/problems/longest-repeating-character-replacement/?company_slug=google)

```java
class Solution {
        public int characterReplacement(String s, int k) {
            int[] num = new int[26];
            int n = s.length();
            int maxn = 0;
            //left:左边界，用于滑动时减去头部或者计算长度
            //right:右边界，用于加上划窗尾巴或者计算长度
            int left = 0, right = 0;
            while (right < n) {
                int indexR = s.charAt(right) - 'A';
                num[indexR]++;
                //求窗口中曾出现某字母的最大次数
                //计算某字母出现在某窗口中的最大次数，窗口长度只能增大或者不变（注意后面left指针只移动了0-1次）
                //这样做的意义：我们求的是最长，如果找不到更长的维持长度不变返回结果不受影响
                maxn = Math.max(maxn, num[indexR]);
               
                //长度len=right-left+1,以下简称len
                //len-字母出现最大次数>替换数目 => len>字母出现最大次数+替换数目
                //分析一下，替换数目是不变的=k,字母出现最大次数是可能变化的，因此，只有字母出现最大次数增加的情况，len才能拿到最大值
                //又不满足条件的情况下，left和right一起移动,len不变的
                if (right - left + 1 - maxn > k) {
                    //这里要减的，因为left越过该点，会对最大值有影响
                    num[s.charAt(left) - 'A']--;
                    left++;
                }
                //走完这里的时候，其实right会多走一步
                right++;
            }
            //因为right多走一步，结果为(right-1)-left+1==right-left
            return right - left;
        }
}
```

**[1049. 最后一块石头的重量 II](https://leetcode.cn/problems/last-stone-weight-ii/?company_slug=google)**

```java
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0; // 计算石头总重量
        for (int weight : stones) {
            sum += weight;
        }
        int n = stones.length, m = sum / 2; // 分割成两堆石头后，每堆的最大重量为 sum/2
        boolean[][] dp = new boolean[n + 1][m + 1]; // dp[i][j] 表示前 i 个石头能否组成重量为 j 的石头堆
        dp[0][0] = true; // 初始化，没有石头时，重量为 0 的石头堆是可以组成的
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (j < stones[i]) {
                    dp[i + 1][j] = dp[i][j]; // 当前石头重量大于剩余最大重量，不能选，继承上一个状态
                } else {
                    dp[i + 1][j] = dp[i][j] || dp[i][j - stones[i]]; // 可选或不选当前石头，转移状态
                }
            }
        }
        for (int j = m;; --j) { // 从最大重量开始，找到最大的能够组成的石头堆
            if (dp[n][j]) {
                return sum - 2 * j; // 返回剩余石头重量差
            }
        }
    }
}

```

[729. 我的日程安排表 I](https://leetcode.cn/problems/my-calendar-i/?company_slug=google)

```java

```

[137. 只出现一次的数字 II](https://leetcode.cn/problems/single-number-ii/?company_slug=google)

```java

```

[1155. 掷骰子的N种方法](https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/?company_slug=google)

```java

```

[539. 最小时间差](https://leetcode.cn/problems/minimum-time-difference/?company_slug=google)

```java

```

[1105. 填充书架](https://leetcode.cn/problems/filling-bookcase-shelves/?company_slug=google)

```java

```

#### [1043. 分隔数组以得到最大和](https://leetcode.cn/problems/partition-array-for-maximum-sum/)

```java

```

# Dijkstra算法详解 通俗易懂

```java
public class Dijkstra {
    public static int[] dijkstra(int[][] graph,int startVertex){
        //初始化 以求出最短路径的点 result[]
        int length = graph.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = -1;
        }
        result[startVertex] = 0 ;
        // 初始化 未求出最短路径的点 notFound[]
        int[] notFound = new int[length];
        for (int i = 0; i < length; i++) {
            notFound[i] = graph[startVertex][i];
        }
        notFound[startVertex] = -1;
        // 开始 Dijkstra 算法
        for (int i = 1; i < length; i++) {
            //1. 从「未求出最短路径的点」notFound 中取出 最短路径的点
            //1.1 找到最短距离的点
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < length; j++) {
                if (notFound[j] > 0 && notFound[j] < min){
                    min = notFound[j];
                    minIndex = j;
                }
            }
            //1.2 将最短距离的点 取出 放入结果中
            result[minIndex] = min;
            notFound[minIndex] = -1;
            //2. 刷新 「未求出最短距离的点」 notFound[] 中的距离
            //2.1 遍历刚刚找到最短距离的点 (B) 的出度 (BA、BB、BC、BD)
            for (int j = 0; j < length; j++) {
                // 出度可通行(例如 BD:graph[1][3]  > 0)
                // 出度点不能已经在结果集 result中(例如 D: result[3] == -1)
                if (graph[minIndex][j] > 0
                && result[j] == -1){
                    int newDistance = result[minIndex] + graph[minIndex][j];
                    //通过 B 为桥梁，刷新距离
                    //（比如`AD = 6 < AB + BD = 4` 就刷新距离）（ -1 代表无限大）
                    if (newDistance < notFound[j] || notFound[j]==-1){
                        notFound[j] = newDistance;
                    }
                }
            }

        }
        return result;
    }
    /** 测试案例 */
    public static void main(String[] args) {
        char[] vertices = new char[]{'A','B','C','D'};
        int[][] graph = new int[][]{
                {0, 2, -1, 6}
                , {2, 0, 3, 2}
                , {-1, 3, 0, 2}
                , {6, 2, 2, 0}};
        int[] dijkstra = dijkstra(graph, 0);
        for (int i : dijkstra) {
            System.out.println(i);
        }
    }
}
测试结果
0
2
5
4
```

#### [997. 找到小镇的法官](https://leetcode.cn/problems/find-the-town-judge/)

```java
class Solution {
    public int findJudge(int n, int[][] trust) {

        // 定义数组用于存放每个人的信任值
        int[] trustValues = new int[n + 1]; // 人员编号从1开始，这里+1防止后续计算麻烦
        
        // 遍历trust数组计算每个人的信任值
        for(int[] t : trust){
            trustValues[t[0]]--;
            trustValues[t[1]]++;
        }

        // 遍历这n个人的信任值，如果存在 n - 1，则返回这个人的编号
        for(int i =1; i <= n;i++){
            if(trustValues[i] == (n - 1)) return i;
        }
        return -1;
    }
}
	
```

# 多图详解并查集

并查集的实现

```java
class UnionFind{
  //每个节点会记录它的父节点。
  private Map<Integer, Integer> father;
}
//当把一个新节点添加到并查集中，它的父节点应该为空
public void add(int x){
  if(!fater.containsKey(x)){
    fater.put(x, null);
  }
}
//合并两个节点
public void merge(int x, int y){
  int rootX = find(x);
  int rootY = find(y);
  if(rootX != rootY){
    fater.put(rootX, rootY);
  }
}
//它们的祖先是否相同
public boolean isConnected(int x, int y){
  return find(x) == find(y);
}
//查找祖先的方法是：如果节点的父节点不为空，那就不断迭代。
public int find(int x){
  int root = x;
  while(father.get(root) != null){
    root = father.get(root);
  }
  return root;
}
//查找祖先的方法是：如果节点的父节点不为空，那就不断迭代。
public int find(int x) {
  int root = x;
  while(fater.get(root) != null){
    root = father.get(root);
  }
  while(x != root ){
    int original_father = father.get(x);
    father.put(x, root);
    x = original_father;
  }
  return root;
}
```

#### [547. 省份数量](https://leetcode.cn/problems/number-of-provinces/)

```java
class UnionFind {
    // 记录父节点
    private Map<Integer,Integer> father;
    // 记录集合的数量
    private int numOfSets = 0;
    
    public UnionFind() {
        father = new HashMap<Integer,Integer>();
        numOfSets = 0;
    }
    
    public void add(int x) {
        if (!father.containsKey(x)) {
            father.put(x, null);
            numOfSets++;
        }
    }
    
    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY){
            father.put(rootX,rootY);
            numOfSets--;
        }
    }
    
    public int find(int x) {
        int root = x;
        
        while(father.get(root) != null){
            root = father.get(root);
        }
        
        while(x != root){
            int original_father = father.get(x);
            father.put(x,root);
            x = original_father;
        }
        
        return root;
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
    
    public int getNumOfSets() {
        return numOfSets;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind();
        for(int i = 0;i < isConnected.length;i++){
            uf.add(i);
            for(int j = 0;j < i;j++){
                if(isConnected[i][j] == 1){
                    uf.merge(i,j);
                }
            }
        }
        
        return uf.getNumOfSets();
    }
}

```

#### 方法一：深度优先搜索

```java
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }
}

```

#### [104. 二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/)

```java
class Solution {
    public int maxDepth(TreeNode root) {
          if(root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
 }
}
```

#### [1768. 交替合并字符串](https://leetcode.cn/problems/merge-strings-alternately/)

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;

        StringBuilder ans = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                ans.append(word1.charAt(i));
                ++i;
            }
            if (j < n) {
                ans.append(word2.charAt(j));
                ++j;
            }
        }
        return ans.toString();
    }
}

```

#### [389. 找不同](https://leetcode.cn/problems/find-the-difference/)

```java
class Solution {
    public char findTheDifference(String s, String t) {
        char ans = t.charAt(t.length()-1);
        for(int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans;
    }
}
```

#### [70. 爬楼梯](https://leetcode.cn/problems/climbing-stairs/)

```java
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
	
```

#### [802. 找到最终的安全状态](https://leetcode.cn/problems/find-eventual-safe-states/)

```java
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n ++i) {
            if (safe(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
}
```

#### [841. 钥匙和房间](https://leetcode.cn/problems/keys-and-rooms/)

```java

class Solution {
    boolean[] vis;
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }
}

```

#### [1376. 通知所有员工所需的时间](https://leetcode.cn/problems/time-needed-to-inform-all-employees/)

```java
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // 如果就一个人，就没有消息传递
        if (n == 1) return 0;
        int ans = 0;
        int[] time = new int[n];
        time[headID] = -1;
        // 遍历进行消息获取
        for (int i = 0; i < n; i++){
            if (time[i] == 0){
                time[i] = getTime(manager, informTime, time, i);
            }
            // 更新最长时间
            if (time[i] > ans)
                ans = time[i];
        }
        return ans;
    }
    private int getTime(int[] manager, int[] informTime, int[] time, int i){
        // 获取负责人坐标
        int aim = manager[i];
        // 如果是总负责人，就不在意他的时间
        if (time[aim] == -1) return informTime[aim];
        // 如果负责人的时间未获取，则先获取负责人的时间
        if (time[aim] == 0) {
            time[aim] = getTime(manager, informTime, time, aim);
        }
        // 返回负责人时间+负责人传递消息耗时
        return time[aim] + informTime[aim];
    }
}


```

#### [1466. 重新规划路线](https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)

```java
class Solution {
    public int minReorder(int n, int[][] connections) {
        //有向无环图的邻接表
        ArrayList<Integer>[] adj = new ArrayList[n];
        //无向无环图的邻接表
        ArrayList<Integer>[] array = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            array[i] = new ArrayList<>();
        }
        // 遍历connections数组
for (int[] connection : connections) {
    // 获取当前连接的起点和终点
    int from = connection[0];
    int to = connection[1];
    // 将终点加入起点的邻接表中
    adj[from].add(to);
    // 将终点加入起点的数组中
    array[from].add(to);
    // 将起点加入终点的数组中，因为这是无向图
    array[to].add(from);
}

        
        int[] num = {0};
        boolean[] visited = new boolean[n];
        //从0城市递归往外走，判断路线方向是否需要改变
        dfs(0,array,adj,num,visited);
        return num[0];
    }

    private void dfs( int i, ArrayList<Integer>[] array, ArrayList<Integer>[] adj, int[] num, boolean[] visited ) {
        visited[i] = true;
        ArrayList<Integer> list = array[i];
        for (int j = 0; j < list.size(); j++) {
            Integer k = list.get( j );
            if (visited[k]) {
                continue;
            }
            //如果路线方向与我们走的方向一致 那需要修改
            if (!adj[k].contains( i )) {
                num[0]++;
            }
            dfs( k,array,adj,num, visited );
        }
    }
}

```

#### [72. 编辑距离](https://leetcode.cn/problems/edit-distance/)

```java

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }
}
```

100.相同的树

```java
class Solution {
    // 定义一个名为 isSameTree 的方法，用于比较两棵二叉树是否相等
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两棵二叉树的根节点都为 null，则它们相等，返回 true
        if(p == null && q == null) 
            return true;
        // 如果其中一个二叉树的根节点为 null，而另一个不为 null，则它们不相等，返回 false
        if(p == null || q == null) 
            return false;
        // 如果两棵二叉树的根节点的值不相等，则它们不相等，返回 false
        if(p.val != q.val) 
            return false;
        // 递归比较两棵二叉树的左右子树是否相等，如果都相等，则它们相等，返回 true，否则返回 false
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

```

#### [1624. 两个相同字符之间的最长子字符串](https://leetcode.cn/problems/largest-substring-between-two-equal-characters/)

```java
class Solution {
    // 定义一个名为 maxLengthBetweenEqualCharacters 的方法，用于计算字符串 s 中任意两个相等字符之间的最大距离
    public int maxLengthBetweenEqualCharacters(String s) {
        // 定义一个长度为 26 的数组 firstIndex，用于记录每个小写字母第一次出现的位置
        int[] firstIndex = new int[26];
        // 初始化数组的值为 -1，表示该字母还未出现过
        Arrays.fill(firstIndex, -1);
        // 定义一个变量 maxLength，用于记录任意两个相等字符之间的最大距离
        int maxLength = -1;
        // 遍历字符串 s 中的每个字符
        for (int i = 0; i < s.length(); i++) {
            // 如果该字符第一次出现，则将它的下标记录到 firstIndex 数组中
            if (firstIndex[s.charAt(i) - 'a'] < 0) {
                firstIndex[s.charAt(i) - 'a'] = i;
            } else {
                // 如果该字符不是第一次出现，则计算它与第一次出现位置之间的距离，与 maxLength 取最大值
                maxLength = Math.max(maxLength, i - firstIndex[s.charAt(i) - 'a'] - 1);
            }
        }
        // 返回任意两个相等字符之间的最大距离
        return maxLength;
    }
}

```

#### [1672. 最富有客户的资产总量](https://leetcode.cn/problems/richest-customer-wealth/)

```java
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max  = 0; // 定义一个变量 max，用来记录最大财富值，初始化为 0
        for(int i = 0; i < accounts.length;i++){ // 遍历每个账户
            int sum = 0; // 定义一个变量 sum，用来记录当前账户的财富值，初始化为 0
            for(int j = 0; j < accounts[i].length; j++){ // 遍历当前账户的每个账户
                sum += accounts[i][j]; // 将当前账户的每个账户的财富值相加
            }
            max = Math.max(max, sum); // 更新最大财富值
        }
        return max; // 返回最大财富值
    }
}

```

[1742. 盒子中小球的最大数量](https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/?company_slug=google)

```java
//时间复杂度：对于给定的 lowLimit 和 highLimit，假设二者之间的数字个数为 n，则代码中的两个循环均执行了 n 次，因此时间复杂度为 O(n)。

//空间复杂度：代码中使用了长度为 46 的数组，因此空间复杂度为 O(1)。

//思路：对于每个盒子号，我们将其每位数字相加，得到一个数字 index，然后将其加入 resultMap 数组中 index 对应的位置，最后找到 resultMap 数组中的最大值即为答案。因为给定的盒子号的范围很小，只有 10^5，因此直接暴力枚举即可，时间复杂度为 O(n)。
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int result = 0; // 定义变量 result，用来记录盒子里的最大球数，初始化为 0
        int[] resultMap = new int[46]; // 定义长度为 46 的数组 resultMap，用来记录每个盒子中的球的数量
        for(int i = lowLimit; i <= highLimit; i++) { // 遍历每个盒子
            int num = i, index = 0;
            while(num > 0) { // 将盒子号每位数字相加
                index += num % 10;
                num = num / 10;
            }
            resultMap[index] += 1; // 将当前盒子的球数量加一
        }
        for (int r : resultMap) result = Math.max(result, r); // 找到盒子中球的最大数量
        return result; // 返回盒子中球的最大数量
    }
}
O(n) 
O(1)
```

#### [933. 最近的请求次数](https://leetcode.cn/problems/number-of-recent-calls/)

```java
class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

```

#### [383. 赎金信](https://leetcode.cn/problems/ransom-note/)

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length()>magazine.length()) {
            return false;
        }

        //定义一个哈希映射数组
        int[] record=new int[26];

        //遍历
        for (char c : magazine.toCharArray()) {
            record[c-'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            record[c-'a']--;
        }
        for (int i : record) {
            if (i<0) {
                return false;//如果数组下标＜0，说明ransomNote中的字符串，magazine中没有
            }
        }
        return true;
    }
}
```

```java

class Solution {	
   public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int addEnergy=0;//训练累计获取精力
        int addExperience=0;//训练累计获取精力
        for (int i = 0; i < energy.length; i++) {
          //需要在经验和精力上都 严格 超过对手才能击败他们，然后在可能的情况下继续对上下一个对手。
           if (initialEnergy<=energy[i]){//需要训练
            //当遇到i位对手时，需要训练获取精力 energy[i]-initialEnergy+1 加1是保证严格大于对手1点精力
               addEnergy+=energy[i]-initialEnergy+1;
              //战胜对手后剩下一点精力
               initialEnergy=1;
           }else {//需要训练
                //精力大于对手，直接扣减精力
               initialEnergy-= energy[i];
           }
//需要在经验和精力上都 严格 超过对手才能击败他们，然后在可能的情况下继续对上下一个对手。
            if (initialExperience<=experience[i]){//需要训练
              //当遇到位i位对手时，需要训练获取经验 experience[i]-initialExperience+1 加1是保证严格大于对手1点经验
                int exp=experience[i]-initialExperience+1;
                //累加需要训练的经验
                addExperience+=exp;
                //累加经验值
                initialExperience+=experience[i]+exp;
            }else {//不需要训练
                 //经验值大于对手，直接增加经验值
                initialExperience+= experience[i];
            }
        }
        //返回需要通过训练增加的精力和经验
       return addEnergy+addExperience;
    }
}

```

#### [28. 找出字符串中第一个匹配项的下标](https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/)

```java
class Solution {
    public int strStr(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        // 枚举原串的「发起点」
        for (int i = 0; i <= n - m; i++) {
            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            // 如果能够完全匹配，返回原串的「发起点」下标
            if (b == m) return i;
        }
        return -1;
    }
}

//比较官方
class Solution{
  public int strStr(String haystack, String needle){
    int n = haystack.length(), m = needle.length();
    char[] h = haystack.toCharArray(), e = needle.toCharArray();
    for( int i = 0; i <= n - m; i++){
      int a = i, b = 0;
      while(b < m && h[a] == e[b]){
       a++;
       b++;
      }
      if(b == m ) return i; 
    }
    return -1;
  }
}
```

#### [48. 旋转图像](https://leetcode.cn/problems/rotate-image/)

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length; // 获取矩阵的长度
        int[][] matrix_new = new int[n][n]; // 创建一个新的矩阵
        for (int i = 0; i < n; ++i) { // 遍历原矩阵的行
            for (int j = 0; j < n; ++j) { // 遍历原矩阵的列
                matrix_new[j][n - i - 1] = matrix[i][j]; // 将旋转后的元素存储在新矩阵中
            }
        }
        for (int i = 0; i < n; ++i) { // 遍历新矩阵的行
            for (int j = 0; j < n; ++j) { // 遍历新矩阵的列
                matrix[i][j] = matrix_new[i][j]; // 将新矩阵中的元素存储回原矩阵中
            }
        }
    }
}

```

#### [49. 字母异位词分组](https://leetcode.cn/problems/group-anagrams/)

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

```

#### [136. 只出现一次的数字](https://leetcode.cn/problems/single-number/)

```java
public int singleNumber(int[] nums) {
    int single = 0; // 定义一个变量single，并初始化为0，用于存储只出现一次的元素
    for (int num : nums) { // 遍历整数数组nums中的所有元素
        single ^= num; // 对single进行异或操作，相同的数字异或后为0，不同的数字异或后为1，最终结果即为只出现一次的数字
    }
    return single; // 返回只出现一次的数字
}

```

只出现一次的数字 II

```java
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }
}
```

