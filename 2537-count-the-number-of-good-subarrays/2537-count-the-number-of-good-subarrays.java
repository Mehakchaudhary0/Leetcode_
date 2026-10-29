
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long pairs = 0,count = 0;

        for (int right = 0; right < nums.length; right++) {
            int x = nums[right];
            pairs += freq.getOrDefault(x, 0);
            freq.put(x, freq.getOrDefault(x, 0) + 1);

            while (pairs >= k) {
                count += nums.length - right;
                int y = nums[left];
                freq.put(y, freq.get(y) - 1);
                pairs -= freq.get(y);
                left++;
            }
        }
        return count;
    }
}
