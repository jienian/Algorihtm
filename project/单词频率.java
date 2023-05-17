import java.util.HashMap;

class WordsFrequency {
    private HashMap<String, Integer> map = new HashMap<>();

    // 构造函数，用于初始化词频统计
    public WordsFrequency(String[] book) {
        // 遍历书中的每个单词
        for (String word : book) {
            // 将单词作为键，统计频率作为值存入哈希表中
            // 如果单词已经存在于哈希表中，则将其对应的频率加1；否则，将频率初始化为1
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

    // 获取指定单词的词频
    public int get(String word) {
        // 如果单词存在于哈希表中，则返回其对应的频率；否则，返回0
        return map.getOrDefault(word, 0);
    }
}


public class Main {
    public static void main(String[] args) {
        // 创建链表：1 -> 2 -> 3 -> 2 -> 1，是一个回文链表
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        
        Solution solution = new Solution();
        boolean isPalindrome = solution.isPalindrome(node1);
        System.out.println("Is the linked list a palindrome? " + isPalindrome);
    }
}
