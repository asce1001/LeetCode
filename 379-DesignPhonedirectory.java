class PhoneDirectory {
    Set<Integer> set;
    Queue<Integer> q;
    int count = 0;

    public PhoneDirectory(int maxNumbers) {
        set = new HashSet<>();
        q = new LinkedList<>();
        for(int i = 0; i < maxNumbers; i++){
            set.add(i);
            q.add(i);
        }
    }
    
    public int get() {
        if(set.isEmpty()) return -1;
        int re = q.poll();
        set.remove(re);
        return re;
    }
    
    public boolean check(int number) {
       return set.contains(number);
    }
    
    public void release(int number) {
        if(!set.contains(number)){
            set.add(number);
            q.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
