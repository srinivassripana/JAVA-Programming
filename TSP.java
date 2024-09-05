import java.util.Arrays;

public class TSP {
    static int INF = Integer.MAX_VALUE;

    public static int tsp(int[][] graph, int mask, int pos, int n, int[][] dp) {
        if (mask == (1 << n) - 1) {
            return graph[pos][0];
        }
        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int ans = INF;

        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = graph[pos][city] + tsp(graph, mask | (1 << city), city, n, dp);
                ans = Math.min(ans, newAns);
            }
        }

        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 }
        };

        int n = graph.length;
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = tsp(graph, 1, 0, n, dp);
        System.out.println("Minimum cost to visit all cities: " + result);
    }
}
