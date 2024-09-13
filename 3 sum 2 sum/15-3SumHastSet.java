class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            Set<Integer> set = new HashSet<>();
            int sum = 0 - nums[i];
            for(int j = i + 1; j < n; j++){
                if(set.contains(sum - nums[j])){
                    //System.out.println("here");
                    List<Integer> li = Arrays.asList(nums[i], nums[j], sum - nums[j]);
                    Collections.sort(li);
                    result.add(li);
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
