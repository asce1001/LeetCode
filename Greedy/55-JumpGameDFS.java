class Solution {
    boolean flag;
    Set<Integer> set;
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length < 2) return true;
        flag = false;
        set = new HashSet<>();
        helper(nums,0, nums.length - 1);
        return flag;
    }

    private void helper(int[] nums, int idx, int n){
        //if(nums[idx] == 0) return;
        System.out.println(idx);
        if(idx >= n){
            flag = true;
            return;
        }
        for(int i = nums[idx]; i >= 0; i--){
            int newIndex = idx + i;
            if(!set.contains(newIndex) && !flag){
                set.add(newIndex)
;                helper(nums, newIndex, n);    
            }
            
        }

    }
}
