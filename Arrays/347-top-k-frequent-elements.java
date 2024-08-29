class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.merge(num, 1, Integer::sum);
        }
        List<Integer> li = new ArrayList<>(map.keySet());
        li.sort((a, b) -> map.get(b) - map.get(a));
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = li.get(i);
        }
        return result;
    }
}


