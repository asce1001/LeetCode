class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        int top = 0;
        int left = 0;
        int bottom = m - 1;
        int right = n - 1;
        int idx = 0;
        List<Integer> result = new ArrayList<>();
        while(top <= bottom && left <= right){
            for(int j = left; j <= right; j++){
                result.add(matrix[top][j]);
                idx++;
            }
            top++;
            if(top <= bottom && left <= right){
                for(int i = top; i <= bottom; i++){
                System.out.println(i + "" + right);
                result.add(matrix[i][right]);
                idx++;
                }
            right--;
            }
            
            if(top <= bottom && left <= right){
                for(int j = right; j >=left; j--){
                result.add(matrix[bottom][j]);
                idx++;
                }
            bottom--;
            }
            
            if(top <= bottom && left <= right){
                for(int i = bottom; i >= top; i--){
                result.add(matrix[i][left]);
                idx++;
                }
            left++;
            }
            
        }
        return result;
    }
}
