class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length; // 获取二维数组的行数
        int w = board[0].length; // 获取二维数组的列数

        boolean[][] visited = new boolean[h][w]; // 创建一个布尔数组用于标记已访问过的位置

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 遍历二维数组的每个位置，并调用 check 方法进行搜索
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        // 检查当前位置的字符是否与目标字符匹配
        if (board[i][j] != s.charAt(k)) {
            return false;
        }
        // 如果已经匹配到目标字符串的最后一个字符，说明匹配成功
        if (k == s.length() - 1) {
            return true;
        }

        visited[i][j] = true; // 将当前位置标记为已访问

        // 定义四个方向的偏移量
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean result = false;

        // 在四个方向上继续搜索
        for (int[] dir : directions) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            
            // 判断新的位置是否在合法范围内，并且未被访问过
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length && !visited[newi][newj]) {
                // 递归调用 check 方法，继续搜索下一个字符
                boolean flag = check(board, visited, newi, newj, s, k + 1);
                if (flag) {
                    result = true;
                    break;
                }
            }
        }

        visited[i][j] = false; // 将当前位置重置为未访问状态

        return result;
    }
}
 优化代码后
 
 class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 在二维数组中找到与目标字符串的首字符匹配的位置作为起点
                if (board[i][j] == word.charAt(0)) {
                    boolean flag = dfs(board, visited, i, j, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        // 当前位置的字符与目标字符串的字符匹配
        if (k == word.length()) {
            return true; // 已经匹配到目标字符串的最后一个字符，匹配成功
        }

        // 边界条件判断
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false; // 越界、已访问、字符不匹配，返回false
        }

        visited[i][j] = true; // 将当前位置标记为已访问

        // 在四个方向上继续搜索
        boolean result = dfs(board, visited, i + 1, j, word, k + 1) // 向下搜索
                || dfs(board, visited, i - 1, j, word, k + 1) // 向上搜索
                || dfs(board, visited, i, j + 1, word, k + 1) // 向右搜索
                || dfs(board, visited, i, j - 1, word, k + 1); // 向左搜索

        visited[i][j] = false; // 将当前位置重置为未访问状态

        return result;
    }
}
