class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        for (int end = 0; end < cards.length; end++) {

            if (map.containsKey(cards[end])) {
                int start = map.get(cards[end]);
                int length = end - start + 1;

                minLength = Math.min(minLength, length);
            }

            map.put(cards[end], end);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}