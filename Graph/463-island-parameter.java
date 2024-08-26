class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int count = 4;
                    for(int[] dir: dirs){
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                            count--;
                        }
                    }
                    perimeter += count;
                }
            }
        }
        return perimeter;
    }
}
