class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> sMap = new HashMap<>();
        Map<String, Character> tMap = new HashMap<>();
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            if(!sMap.containsKey(ch)){
                if(!tMap.containsKey(arr[i])){
                    sMap.put(ch, arr[i]);
                    tMap.put(arr[i], ch);
                } else if (!tMap.get(arr[i]).equals(ch)){
                    return false;
                }
            }
             else if (!sMap.get(ch).equals(arr[i])){
                return false;
            }
        }
        return true;
    }
}
