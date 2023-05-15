import java.util.HashSet;

public class Main {
    public HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<Integer>();
        HashSet<String> visited = new HashSet<String>();
        getAllLengths(k, 0, shorter, longer, lengths, visited);
        return lengths;
    }

    private void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths,
            HashSet<String> visited) {
        if (k == 0) {
            lengths.add(total);
            return;
        }
        String key = k + " " + total;
        if (visited.contains(key)) {
            return;
        }
        getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited);
        getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited);
        visited.add(key);
    }

    public static void main(String[] args) {
        Main solution = new Main();
        int k = 3;
        int shorter = 2;
        int longer = 3;
        HashSet<Integer> lengths = solution.allLengths(k, shorter, longer);
        System.out.println("Possible lengths:");
        for (int length : lengths) {
            System.out.println(length);
        }
    }
}
注释版：
HashSet<Integer> allLengths(int k, int shorter, int longer) {
    HashSet<Integer> lengths = new HashSet<Integer>(); // 用于存储所有可能的长度
    HashSet<String> visited = new HashSet<String>(); // 用于记录已访问的状态
    getAllLengths(k, 0, shorter, longer, lengths, visited); // 调用递归函数获取长度
    return lengths; // 返回结果集合
}

void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths, HashSet<String> visited) {
    if (k == 0) {
        lengths.add(total); // 当达到指定的分段数目 k 时，将当前总长度 total 添加到结果集合中
        return;
    }
    
    String key = k + " " + total; // 生成当前状态的唯一标识
    if (visited.contains(key)) {
        return; // 如果当前状态已经访问过，则直接返回，避免重复计算
    }
    
    // 递归调用，分别考虑选择 shorter 或 longer 的情况
    getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited); // 选择 shorter
    getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited); // 选择 longer
    
    visited.add(key); // 将当前状态添加到已访问的集合中
}

面试题 16.11. 跳水板
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0) return new int[0];
        if(shorter == longer) return new int[]{shorter * k};

        int[] lengths = new int[k + 1];
        for(int i = 0; i <= k;i++){
            lengths[i] = shorter * (k - i) + longer * i;
        }
        return lengths;
    }
}
注释版：
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        // 如果没有木板，则返回空数组
        if (k == 0) return new int[0];
        
        // 如果短木板和长木板长度相同，则只有一种长度组合
        if (shorter == longer) return new int[]{shorter * k};

        // 存储所有可能的长度组合
        int[] lengths = new int[k + 1];
        
        // 根据短木板和长木板的数量计算每种长度组合
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }
        
        // 返回所有长度组合
        return lengths;
    }
}


