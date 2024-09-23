class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int rSum = 0;
        map.put(0, -1);
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                rSum--;
            } else{
                rSum++;
            }
            if(!map.containsKey(rSum)){
                map.put(rSum, i);
            } else {
                result = Math.max(result, i - map.get(rSum));
            }
        }
        return result;
    }
}
