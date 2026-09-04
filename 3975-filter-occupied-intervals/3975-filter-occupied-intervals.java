class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(occupiedIntervals[0]);

        for (int i = 1; i < occupiedIntervals.length; i++) {
            int[] current = occupiedIntervals[i];
            int[] last = merged.get(merged.size() - 1);
            if (last[1] + 1 >= current[0]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] interval : merged) {

            int start = interval[0];
            int end = interval[1];

            if (end < freeStart || start > freeEnd) {
                ans.add(Arrays.asList(start, end));
            } 
            else {
                if (start < freeStart) {
                    ans.add(Arrays.asList(start, freeStart - 1));
                }
                if (end > freeEnd) {
                    ans.add(Arrays.asList(freeEnd + 1, end));
                }
            }
        }
        return ans;
    }
}