class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0)
      return 0;
    int m = matrix.length;
    int n = matrix[0].length;
    boolean flag = false;
    int max = Integer.MIN_VALUE;
    // int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == '1') {
        max = 1;
      }
    }
    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == '1') {
        max = 1;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == '1') {
          int up = matrix[i - 1][j] - '0';
          int left = matrix[i][j - 1] - '0';
          int diagUp = matrix[i - 1][j - 1] - '0';
          int curr = 1 + Math.min(up, Math.min(left, diagUp));
          max = Math.max(max, curr);
          matrix[i][j] = (char) (curr + '0');
        }
      }
    }
    return max * max;
  }
}
