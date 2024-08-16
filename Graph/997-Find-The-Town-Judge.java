class Solution {
  public int findJudge(int n, int[][] trust) {
    int[] indegrees = new int[n];
    int count = 0;
    for (int[] edge : trust) {
      indegrees[edge[1] - 1]++;
      indegrees[edge[0] - 1]--;
    }
    for (int i = 0; i < n; i++) {
      if (indegrees[i] == n - 1) {
        return i + 1;
      }
    }
    return -1;
  }
}
