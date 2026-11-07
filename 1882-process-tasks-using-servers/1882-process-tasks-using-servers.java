class Solution {

    static class FreeServer {
        int weight;
        int index;

        FreeServer(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }

    static class BusyServer {
        long freeTime;
        int weight;
        int index;

        BusyServer(long freeTime, int weight, int index) {
            this.freeTime = freeTime;
            this.weight = weight;
            this.index = index;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        // Free Servers: minimum weight, then minimum index
        PriorityQueue<FreeServer> fServer = new PriorityQueue<>(
            (a, b) -> {
                if (a.weight != b.weight) {
                    return Integer.compare(a.weight, b.weight);
                }

                return Integer.compare(a.index, b.index);
            }
        );

        // Busy Servers: minimum freeTime, then weight, then index
        PriorityQueue<BusyServer> bServer = new PriorityQueue<>(
            (a, b) -> {
                if (a.freeTime != b.freeTime) {
                    return Long.compare(a.freeTime, b.freeTime);
                }

                if (a.weight != b.weight) {
                    return Integer.compare(a.weight, b.weight);
                }

                return Integer.compare(a.index, b.index);
            }
        );

        // Add all servers to freeServer heap
        for (int i = 0; i < n; i++) {
            fServer.offer(new FreeServer(servers[i], i));
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {

            // Move completed tasks' servers to free heap
            while (!bServer.isEmpty() && bServer.peek().freeTime <= i) {

                BusyServer s = bServer.poll();

                fServer.offer(new FreeServer(s.weight, s.index));
            }

            // If no server is free
            if (fServer.isEmpty()) {

                BusyServer s = bServer.poll();

                result[i] = s.index;

                bServer.offer(new BusyServer(
                    s.freeTime + tasks[i],
                    s.weight,
                    s.index
                ));
            }

            // If a free server is available
            else {

                FreeServer s = fServer.poll();

                result[i] = s.index;

                bServer.offer(new BusyServer(
                    (long) i + tasks[i],
                    s.weight,
                    s.index
                ));
            }
        }

        return result;
    }
}