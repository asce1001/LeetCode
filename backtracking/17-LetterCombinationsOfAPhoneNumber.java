class Solution {
    private Map<Character, String> digitToChar = Map.of(
        '2', "abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
        List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits == null || digits.length() == 0 ) return new ArrayList<>();
        helper(digits, 0, "");
        return result;
    }

    private void helper(String digits, int pivot, String curr){
        // base
        if(curr.length() == digits.length()){
            result.add(curr);
            return;
        }

        // logic
        for(int i = pivot; i < digits.length(); i++){
            String s = digitToChar.get(digits.charAt(pivot));
            for(char c : s.toCharArray()){
                helper(digits, i + 1, curr + c);
            }
        }
    }
}
