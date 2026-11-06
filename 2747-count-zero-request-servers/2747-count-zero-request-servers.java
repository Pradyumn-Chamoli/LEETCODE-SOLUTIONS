

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int m = logs.length;
        int q = queries.length;

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] result = new int[q];

        int[][] timeIndex = new int[q][2];

        for (int i = 0; i < q; i++) {
            timeIndex[i][0] = queries[i];
            timeIndex[i][1] = i;
        }

        Arrays.sort(timeIndex, (a, b) -> 
            Integer.compare(a[0], b[0])
        );

        HashMap<Integer, Integer> mp = new HashMap<>();

        int i = 0;
        int j = 0;

        for (int[] query : timeIndex) {

            int time = query[0];
            int idx = query[1];

            int start = time - x;
            int end = time;

            while (j < m && logs[j][1] <= end) {

                mp.put(
                    logs[j][0],
                    mp.getOrDefault(logs[j][0], 0) + 1
                );

                j++;
            }

            while (i < m && logs[i][1] < start) {

                int serverId = logs[i][0];

                mp.put(serverId, mp.get(serverId) - 1);

                if (mp.get(serverId) == 0) {
                    mp.remove(serverId);
                }

                i++;
            }

            result[idx] = n - mp.size();
        }

        return result;
    }
}
