class Solution {
    int m;
    int n;
    int[][] dirs;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1},{-1, -1},{-1, 1},{1, -1},{1, 1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countAlive(board, m, n, i, j);
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                } else if (board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countAlive(int[][] board, int m, int n, int i, int j){
            int count = 0;
            for(int[] dir: dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 3)){
                    count++;
                }
            }
            return count;
        }
}

    
