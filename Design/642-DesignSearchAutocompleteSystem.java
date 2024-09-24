class AutocompleteSystem {
    HashMap<String, Integer> map;
    StringBuilder input;
    public AutocompleteSystem(String[] sentences, int[] times) {
        this.map = new HashMap<>();
        input = new StringBuilder();
        for(int i = 0; i < sentences.length; i++){
            String sentence = sentences[i];
            map.put(sentence, map.getOrDefault(sentence, 0) + times[i]);
        }
    }
    
    public List<String> input(char c) {
        if(c == '#'){
            String search = input.toString();
            map.put(search, map.getOrDefault(search, 0) + 1);
            input = new StringBuilder();
            return new ArrayList<>();
        }
        input.append(c);
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(map.get(a) == map.get(b)){
                return b.compareTo(a);
            }
            return map.get(a) - map.get(b);
        });
        String prefix = input.toString();
        for(String key: map.keySet()){
            if(key.startsWith(prefix)){
                pq.add(key);
                if(pq.size() > 3){
                    pq.poll();
                }
            }
        }
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            System.out.println(result);
            result.add(0, pq.poll());
        }
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
