import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (char ch : s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        int length = 0;
        boolean odd = false;

        for (int freq : count.values()) {
            length += (freq / 2) * 2;

            if (freq % 2 == 1) {
                odd = true;
            }
        }

        if (odd) {
            length++;
        }

        return length;
    }
}