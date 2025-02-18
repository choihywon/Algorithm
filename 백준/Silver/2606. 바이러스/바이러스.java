import java.io.*;
import java.util.*;

class Solution {
    private int count = 0;
    public void dfs(int node, int[][] map, boolean[] visited) {
        visited[node] = true;
        for(int i = 1; i < map.length; i++) {
            if(map[node][i] == 1 && !visited[i]) {
                count++;
                dfs(i, map, visited);
            }
        }
    }
    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        Solution solution = new Solution();
        solution.dfs(1, map, visited);
        System.out.println(solution.getCount());
    }
}