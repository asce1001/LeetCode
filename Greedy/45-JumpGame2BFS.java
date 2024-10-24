class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        int jumps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                int i  = q.poll();
                for(int j = 1; j <= nums[i]; j++){
                    int newIdx = i + j;
                    if(newIdx == nums.length - 1) return jumps;
                    if(!set.contains(i + j)){
                        set.add(i + j);
                        q.add(i + j);
                    }
                }
            }
            jumps++;
        }
        return -1;
    }
}
