class Solution {
    int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                } else if (mat[i][j] == 1){
                    mat[i][j] = -1;
                }
            }
        }
        int distance = 0;
        if(q.size() == m *n) return mat;
        while(!q.isEmpty()){
            int size = q.size();
                 int[] curr = q.poll();
                for(int[] dir: dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                        q.add(new int[]{nr, nc});
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    }
                }
            distance++;
        }
        return mat;
    }
}
