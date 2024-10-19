class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    q.add(new int[]{i,j});
                    grid[i][j] = '2';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int nr = dir[0] + curr[0];
                            int nc = dir[1] + curr[1];
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                                q.add(new int[]{nr, nc});
                                grid[nr][nc] = '2';
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
