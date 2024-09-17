class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Double, List<String>> map = new HashMap<>();
        for(String s : strs){
            double key = primeProduct(s);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private double primeProduct(String key){
        Double product = 1.0;
        int primeArray[] = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for(int i = 0; i < key.length(); i++){
            product = product * primeArray[key.charAt(i) - 'a'];
        }
        return product;
    }
}
