class MyHashMap {
    int[][] map;
    int bucket;
    int bucketSize;

    public MyHashMap() {
        bucket = 1000;
        bucketSize = 1000;
        map = new int[bucket][];
    }

    private int key1(int key){
        return key % 1000;
    }
    
    
    private int key2(int key){
        return key / 1000;
    }

    public void put(int key, int value) {
        int k1 = key1(key);
        int k2 = key2(key);
        if(map[k1] == null){
            if(k1 == 0) {
                map[k1] = new int[bucketSize + 1];
            } else {
                map[k1] = new int[bucketSize];
            }
            
            Arrays.fill(map[k1], -1);
        }
        map[k1][k2] = value;
    }
    
    public int get(int key) {
        int k1 = key1(key);
        int k2 = key2(key);
        if(map[k1] == null) return -1;
        return map[k1][k2];
    }
    
    public void remove(int key) {
        int k1 = key1(key);
        int k2 = key2(key);
        if(map[k1] == null) return;
        map[k1][k2] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
