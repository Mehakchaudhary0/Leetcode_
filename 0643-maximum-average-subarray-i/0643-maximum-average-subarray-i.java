class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int window = 0;
        for (int i = 0; i < k; i++) {
            window += nums[i];
        }

        int maxSum = window;
        for (int i = k; i < nums.length; i++) {
            window += nums[i];
            window -= nums[i - k];

            maxSum = Math.max(maxSum, window);
        }
        return (double) maxSum / k;
    }
}