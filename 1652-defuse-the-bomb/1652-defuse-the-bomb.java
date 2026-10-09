class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        if (k == 0) {
            return ans;
        }

        int start = 1;
        int end = k;
        int sum = 0;
        
        if (k < 0) {
            start = n + k;
            end = n - 1;
        }
        for (int i = start; i <= end; i++) {
            sum += code[(i + n) % n];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            sum -= code[(start + n) % n];
            start++;
            end++;
            sum += code[end % n];
        }
        return ans;
    }
}