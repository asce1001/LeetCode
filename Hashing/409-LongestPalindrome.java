class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        if(s.isEmpty()) return 0;
        int count = 0;
        for(int i = 0; i <s.length(); i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count += 2;
            } else {
                set.add(s.charAt(i));
            }
        }
        if(!set.isEmpty()){
            System.out.print(set);
            count++;
        }
        return count;
    }
}
