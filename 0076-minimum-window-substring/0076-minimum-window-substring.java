class Solution {
    public String minWindow(String s, String t) {
        int windowStart =0, windowEnd=0, startIndex = -1, length= Integer.MAX_VALUE, matched =0;

        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int index=0; index < t.length(); index++){
            char currChar = t.charAt(index);
            tMap.put(currChar, tMap.getOrDefault(currChar, 0)+1);
        }

        for(; windowEnd < s.length(); windowEnd++){
            char currChar = s.charAt(windowEnd);
            if(tMap.containsKey(currChar)){
                tMap.put(currChar, tMap.get(currChar) - 1);
                if(tMap.get(currChar) >= 0){
                    matched += 1;
                }
            }

            while(matched == t.length()){
                if(length > (windowEnd - windowStart + 1)){
                    length = (windowEnd - windowStart + 1);
                    startIndex = windowStart;
                }
                char startChar = s.charAt(windowStart++);
                if(tMap.containsKey(startChar)){
                    if(tMap.get(startChar) == 0){
                        matched -= 1;
                    }
                    tMap.put(startChar, tMap.get(startChar) + 1);
                }
            }
        }
        if(startIndex == -1) return "";

        return s.substring(startIndex, startIndex + length);
    }
}
