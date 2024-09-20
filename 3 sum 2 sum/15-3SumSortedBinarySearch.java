class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        if(nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < n - 1; j++){
                int tempTarget = nums[i] + nums[j];
                int low = j + 1;
                int high = n - 1;
                while(low <= high){
                    int mid = low + (high - low)/ 2;
                    //System.out.println(tempTarget + nums[mid]);
                    if(tempTarget + nums[mid] == 0){
                        result.add(Arrays.asList(nums[i], nums[j], nums[mid]));
                        low++; high--;
                        while(low <= high && nums[low] == nums[low-1]){
                            low++;
                        }
                        while(low <= high && nums[high] == nums[high + 1]){
                            high--;
                        }
                    } else if(tempTarget + nums[mid] < 0){
                        low = mid + 1;
                    } else {
                        high = mid - 1;;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
