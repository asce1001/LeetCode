class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0)
      return 0;
    int m = matrix.length;
    int n = matrix[0].length;
    boolean flag = false;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          flag = true;
          int k = 1;
          while (i + k < m && j + k < n && flag) {
            for (int r = i + k; r >= i; r--) {
              if (matrix[r][j + k] == '0') {
                flag = false;
                break;
              }
            }
            for (int c = j + k; c >= j; c--) {
              if (matrix[i + k][c] == '0') {
                flag = false;
                break;
              }
            }
            if (flag) {
              k++;
            }
          }
          max = Math.max(max, k);
        }
      }
    }
    return max * max;
  }
}
