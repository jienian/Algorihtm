public void dfsMatrix(int[][] matrix, boolean[][] visited, int x, int y) {
    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return;
    if (visited[x][y]) return;
    visited[x][y] = true;
    dfsMatrix(matrix, visited, x - 1, y);//上
    dfsMatrix(matrix, visited, x + 1, y);//下
    dfsMatrix(matrix, visited, x, y - 1);//左
    dfsMatrix(matrix, visited, x, y + 1);//右
    visited[x][y] = false;
}
