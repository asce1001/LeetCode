class AutocompleteSystem {
    class TrieNode{
        TrieNode[] children;
        List<String> li;
        public TrieNode(){
            children = new TrieNode[256];
            li = new ArrayList<>();            
        }
    }

    private void insert(String sentence){
        TrieNode curr = root;
        for(int i = 0; i < sentence.length(); i++){
            char c = sentence.charAt(i);
            if(curr.children[c- ' '] == null){
                curr.children[c- ' '] = new TrieNode();
            }
            curr = curr.children[c - ' '];
            curr.li.add(sentence);
        }
    }

    private List<String> search(String prefix){
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c - ' '] == null){
                return new ArrayList<>();
            }
            curr = curr.children[c - ' '];
        }
        return curr.li;
    }

    HashMap<String, Integer> map;
    StringBuilder input;
    TrieNode root;
    public AutocompleteSystem(String[] sentences, int[] times) {
        this.map = new HashMap<>();
        this.root = new TrieNode();
        this.input = new StringBuilder();
        for(int i = 0; i < sentences.length; i++){
            String sentence = sentences[i];
            if(!map.containsKey(sentence)){
                insert(sentence);
            }
            map.put(sentence,times[i]);
        }
    }
    
    public List<String> input(char c) {
        if(c == '#'){
            String search = input.toString();
            if(!map.containsKey(search)){
                insert(search);
            }
            map.put(search, map.getOrDefault(search, 0) + 1);
            input = new StringBuilder();
            return new ArrayList<>();
        }
        input.append(c);
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) ->{
            if(map.get(a) == map.get(b)){
                return b.compareTo(a);
            } else {
                return map.get(a) - map.get(b);
            }
        });
        ArrayList<String> result = new ArrayList<>();
        String prefix = input.toString();
        List<String> startsWith = search(prefix);
        for(String str: startsWith){
            if(str.startsWith(prefix)){
                pq.add(str);
                if(pq.size() > 3){
                    pq.poll();
                }
            }
        }
        
        while(!pq.isEmpty()){
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
