class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        //int low = 0;
        //int high = numbers.length - 1;
        for (int i = 0; i < numbers.length - 1; i++){
            int curr = i;
            int low = curr + 1;
            int high = numbers.length - 1;
            int tempTarget  = target - numbers[curr];
            while(low <= high){
                int mid = low + (high - low)/ 2;
                //System.out.println(numbers[mid]);
                if(numbers[mid] == tempTarget){
                    result[0] = curr + 1;
                    result[1] = mid + 1;
                    return result;
                } else if (numbers[mid] > tempTarget){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return result;
    }
}
