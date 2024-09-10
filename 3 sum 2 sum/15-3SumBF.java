class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> li = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(li);
                        result.add(li);
                        // int[] arr = new int[]{nums[i], nums[j], nums[k]};
                        // Arrays.sort(arr);
                        // result.add(new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new))));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
