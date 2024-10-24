class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length < 2) return true;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(0); set.add(0);
        int n = nums.length - 1 ;
        while(!q.isEmpty()){
            int i = q.poll();
            for(int j = nums[i]; j >= 0; j--){
                int idx = i + j;
                if(idx  == n) return true;
                if(!set.contains(idx)){
                    q.add(idx);
                    set.add(idx);
                }
                
            }
        }
        return false;
    }
}
