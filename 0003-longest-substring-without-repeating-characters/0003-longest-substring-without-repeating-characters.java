class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        int ans = 0, j = -1;

        for (int i = 0; i < s.length(); i++) {
            j = Math.max(j, lastSeen[s.charAt(i)]);
            ans = Math.max(ans, i - j);
            lastSeen[s.charAt(i)] = i;
        }
        return ans;
    }
}