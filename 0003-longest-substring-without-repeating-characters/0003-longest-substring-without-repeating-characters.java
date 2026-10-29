class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0, windowEnd =0, length=0;

        HashMap<Character, Integer> indexMap = new HashMap<>();

        for(; windowEnd < s.length(); windowEnd += 1){
            char currentChar = s.charAt(windowEnd);
            if(indexMap.containsKey(currentChar)){
                windowStart = Math.max(windowStart, indexMap.get(currentChar) + 1);
            }
            length = Math.max(length, (windowEnd - windowStart + 1));
            indexMap.put(currentChar, windowEnd);
        }
        return length;
    }
}