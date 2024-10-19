class Solution {
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        if(image == null || image.length == 0){
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor){
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}
