import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // [start, end, weight, originalIndex]
        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        // Sort by ending time
        Arrays.sort(a, (x, y) -> {
            if (x[1] != y[1])
                return Integer.compare(x[1], y[1]);

            return Integer.compare(x[0], y[0]);
        });

        // dp[i][k] = maximum weight using first i intervals
        // with at most k intervals
        long[][] dp = new long[n + 1][5];

        // Store selected indices for every state
        List<Integer>[][] path = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                path[i][k] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {

            int start = a[i - 1][0];
            int weight = a[i - 1][2];
            int index = a[i - 1][3];

            // Last interval whose end < current start
            int prev = findPrevious(a, i - 1, start);

            for (int k = 1; k <= 4; k++) {

                // Option 1: Don't take current interval
                dp[i][k] = dp[i - 1][k];
                path[i][k] = new ArrayList<>(path[i - 1][k]);

                // Option 2: Take current interval
                long newWeight = dp[prev][k - 1] + weight;

                List<Integer> newPath =
                    new ArrayList<>(path[prev][k - 1]);

                newPath.add(index);

                Collections.sort(newPath);

                if (newWeight > dp[i][k] ||
                    (newWeight == dp[i][k]
                    && isLexicographicallySmaller(newPath, path[i][k]))) {

                    dp[i][k] = newWeight;
                    path[i][k] = newPath;
                }
            }
        }

        List<Integer> answer = path[n][4];

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    // Find number of intervals whose end < start
    private int findPrevious(int[][] a, int right, int start) {

        int left = 0;
        int ans = 0;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (a[mid][1] < start) {
                ans = mid + 1;
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return ans;
    }

    // Compare two lists lexicographically
    private boolean isLexicographicallySmaller(
        List<Integer> a,
        List<Integer> b
    ) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}