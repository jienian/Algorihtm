/*

 * 1. HashMap
    内部结构：基于哈希表实现，使用哈希函数来决定元素的存储位置。
    顺序：不保证任何顺序；随着元素的增加，顺序可能发生变化。
    性能：提供常数时间的性能（O(1)）对于 get 和 put 操作，假设哈希函数将元素均匀分布。
    用例：当需要高效的查找、插入和删除操作，且元素顺序不重要时，HashMap 是一个好选择。

2. LinkedHashMap
    内部结构：基于哈希表和链表实现，维护元素的插入顺序或访问顺序。
    顺序：按照元素的插入顺序或者访问顺序（取决于构造函数的一个参数）来维护键值对的顺序。
    性能：略低于 HashMap，因为它需要额外维护元素的顺序，但大部分操作仍可接近 O(1)。
    用例：当需要保持映射的顺序时，如在缓存场景下按访问顺序自动删除最老的条目（LRU 缓存）。
    
3. TreeMap
    内部结构：基于红黑树（一种自平衡二叉查找树）实现。
    顺序：根据键的自然顺序或构造时提供的 Comparator 来排序。
    性能：对于包括 get、put 和 remove 在内的操作，提供对数时间的性能（O(log n)）。
    用例：当需要一个总是有序的映射时，或者需要根据键的顺序提取条目时，TreeMap 是最合适的。
 
 */
/*HashMap
适用于快速查找的应用，如用户账户信息映射： */
 Map<String, String> userMap = new HashMap<>();
userMap.put("username1", "John Doe");
userMap.put("username2", "Jane Doe");
// 快速检索：
String name = userMap.get("username1");

/*LinkedHashMap
适用于需要保持插入顺序的场景，如保存任务执行的顺序： */
Map<Integer, String> taskOrder = new LinkedHashMap<>();
taskOrder.put(1, "Initialize");
taskOrder.put(2, "Start");
taskOrder.put(3, "Stop");
// 保持任务的插入顺序
for (Map.Entry<Integer, String> entry : taskOrder.entrySet()) {
    System.out.println(entry.getKey() + " => " + entry.getValue());
}

/*TreeMap
适用于需要根据键排序的场景，如存储学生的成绩并需要按成绩排序： */
Map<Integer, String> grades = new TreeMap<>();
grades.put(90, "Alice");
grades.put(85, "Bob");
grades.put(92, "Charlie");
// 自动按成绩排序
for (Map.Entry<Integer, String> entry : grades.entrySet()) {
    System.out.println(entry.getKey() + " => " + entry.getValue());
}

