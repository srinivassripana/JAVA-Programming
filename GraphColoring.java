import java.util.Arrays;

public class GraphColoring {
    private int V; // Number of vertices
    private int[] colors; // Colors assigned to vertices
    private int[][] graph; // Graph representation

    public GraphColoring(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        this.colors = new int[V];
        Arrays.fill(colors, -1); // Initialize colors as unassigned
    }

    // Check if the current color assignment is safe for vertex v
    private boolean isSafe(int v, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && c == colors[i])
                return false;
        }
        return true;
    }

    // Recursive function to solve graph coloring using backtracking
    private boolean graphColoringUtil(int v) {
        // Base case: If all vertices are assigned a color, return true
        if (v == V)
            return true;

        // Try different colors for vertex v
        for (int c = 0; c < V; c++) {
            // Check if color assignment is safe
            if (isSafe(v, c)) {
                colors[v] = c;

                // Recur for next vertex
                if (graphColoringUtil(v + 1))
                    return true;

                // If assigning color c doesn't lead to a solution, backtrack
                colors[v] = -1;
            }
        }

        // If no color can be assigned to this vertex, return false
        return false;
    }

    // Function to solve graph coloring problem
    public boolean graphColoring() {
        // Start from vertex 0
        if (!graphColoringUtil(0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        // Print the color assignments
        printSolution();
        return true;
    }

    // Print the color assignments
    private void printSolution() {
        System.out.println("Color assignments:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " --> Color " + colors[i]);
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
                { 0, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 0 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 0 }
        };

        GraphColoring gc = new GraphColoring(graph);
        gc.graphColoring();
    }
}
