class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sChar =  s.charAt(i);
            char tChar = t.charAt(i);
            if(!sMap.containsKey(sChar)){
                if(!tMap.containsKey(tChar)){
                    sMap.put(sChar, tChar);
                    tMap.put(tChar, sChar);
                }
                if(tMap.get(tChar) != sChar) return false;
            } 
            if(sMap.get(sChar) != tChar) return false;
        }
        return true;
    }
}
