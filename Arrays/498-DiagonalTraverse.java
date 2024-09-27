class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int size = m * n;
        int count = 0;
        int dir = 1;
        int i = 0;
        int j = 0;
        int[] result = new int[size];
        while (count < size){
            result[count] = mat[i][j];
            if(dir == 1){
                if(j == n - 1){
                    i++;
                    dir = -1;
                } else if (i == 0){
                    j++;
                    dir = -1;
                } else {
                    i--;
                    j++;
                }
                
            } else if (dir == -1){
                if(i == m - 1){
                    j++;
                    dir = 1;
                } else if (j == 0){
                    i++;
                    dir = 1;
                } else {
                    i++;
                    j--;
                }
                
            }
            count++;
        } 
        return result;
    }
}
