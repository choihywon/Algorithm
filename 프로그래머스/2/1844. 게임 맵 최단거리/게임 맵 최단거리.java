import java.io.*;
import java.util.*;


class Solution {
    public int n,m;
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};

    //맵 구성
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        //시작 부분
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int distance = cur[2];
            //종료 조건
            if(x == n-1 && y == m-1) {
                return distance;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //
                //맵 안에 있어야하고
                //벽이면 안되고
                //방문 안한 곳ㅇ어야하고
                //생각해보니 갈 수 있는 길이어야함
                if(nx >= 0 && ny >= 0 && nx < n && ny < m  && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }


}