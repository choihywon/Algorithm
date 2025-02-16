import java.io.*;
import java.util.*;

class Solution {
    private int N, M;
    private List<int[]> edges;
    private int[] parent;

    public Solution(int N, int M, List<int[]> edges) {
        this.N = N;
        this.M = M;
        this.edges = edges;
        this.parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
    }

    public int getMinCostAfterSplitting() {
        edges.sort(Comparator.comparingInt(a -> a[2]));

        int mstCost = 0;
        int maxEdge = 0;
        int edgeCount = 0;

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], cost = edge[2];

            if (union(a, b)) {
                mstCost += cost;
                maxEdge = cost;
                edgeCount++;

                if (edgeCount == N - 1) break; 
            }
        }

        return mstCost - maxEdge; 
    }

    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) 
            return false; 

        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;

        return true;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new int[]{A, B, C});
        }

        Solution solution = new Solution(N, M, edges);
        System.out.println(solution.getMinCostAfterSplitting());
    }
}
