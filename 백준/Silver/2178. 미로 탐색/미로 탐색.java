import java.util.*;
import java.io.*;
class Solution {
    private int[][] map;
    private int[][] dist;
    private int n, m;

    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public Solution(int[][] map, int n, int m) {
        this.map = map;
        this.n = n;
        this.m = m;
        this.dist = new int[n][m];
    }

    public int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        dist[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];


                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[cx][cy] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Solution solution = new Solution(map, n, m);
        System.out.println(solution.bfs(0, 0));
    }
}