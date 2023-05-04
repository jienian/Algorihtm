class Solution{
    public boolean findWhetherExistsPath(int n , int[][] Grach, int start, int target){
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : grach){
            int from = edge[0], to = edge[1];
            adjList.putIfAbsent(from, new ArrayList<>());
            adjList.get(from).add(to);  
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int curr == queue.poll();
            if(curr == target){
                return true;
            }
            if(adjList.containsKey(curr)){
                for(int next : adjList.get(curr)){
                    if(!visited[next]){
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return false;
    }
}