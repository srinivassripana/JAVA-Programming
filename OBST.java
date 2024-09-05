public class OBST {
    public static int optimalBST(int[] keys, int[] freq) {
        int n = keys.length;
        int[][] cost = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) { // Corrected index bounds here
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;
                int sum = getSum(freq, i, j);

                for (int r = i; r <= j; r++) {
                    int c = ((r > i) ? cost[i][r - 1] : 0) +
                            ((r < j) ? cost[r + 1][j] : 0) + sum;
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[0][n - 1];
    }

    private static int getSum(int[] freq, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] keys = { 10, 12, 20 };
        int[] freq = { 34, 8, 50 };
        int result = optimalBST(keys, freq);
        System.out.println("Cost of Optimal BST is " + result);
    }
}
