class Solution {
    int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        if(mat == null || mat.length == 0) return mat;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                } else mat[i][j] = -1;
            }
        }
        if(q.size() == m * n) return mat;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                        q.add(new int[]{nr, nc});
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    }
                }
            }
        }
        return mat;
    }
}
