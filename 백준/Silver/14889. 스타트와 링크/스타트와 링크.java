import java.util.*;
import java.io.*;

class Solution {
    private int n;
    private int[][] map;
    private boolean[] visited;
    private int minDiff = Integer.MAX_VALUE;

    public Solution(int[][] num) {
        this.n = num.length;
        this.map = num;
        this.visited = new boolean[n];
    }

    //팀 결정 하기 위해서 팀 조합 생각
    //팀 조합에서 점수 합산
    //점수 비교
    //4
    //0 1 2 3
    //4 0 5 6
    //7 1 0 2
    //3 4 5 0
    // 일단 팀 나눠보자
    // 0 1 , 2 3
    // 0 2 , 1 3
    // 0 3 , 1 2

    public void finalTeam() {
        madeTeam(0,0);
        System.out.print(minDiff);
    }

    //팀 조합 만들기(유사 메뉴 리뉴얼)
    public void madeTeam(int index, int count) {
        //이건 능력차이 불러와야하기 때문(재귀 종료 조건)
        if(count ==  n/2) {
            teamAvility();
            return;
        }
        //startTeam은 true linkTeam은 false로 해서 비교하기 위함
        for(int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                madeTeam(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
    //팀 능력치 계산

    //스타트 팀과 링크 팀 조합 점수를 계산해야함
    //4
    //0 1 2 3
    //4 0 5 6
    //7 1 0 2
    //3 4 5 0
    // 일단 팀 나눠보자
    // 0 1 , 2 3
    // 0 2 , 1 3
    // 0 3 , 1 2
    //0 1 -> s[0][1] + s[1][0] / 2 3 l[1][2]+l[2][1]
    //쯕쯕빈벅힌 다음에
    //ssum과 lsum이 차이가 작을 때 반환시키기

    public void teamAvility() {
        int startTeam = 0, linkTeam = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i] && visited[j]) {
                    startTeam += map[i][j];
                } else if(!visited[i] && !visited[j]) {
                    linkTeam += map[i][j];
                }
            }
        }
        //팀별로 점수를 합산 했으니
        //이젠 차이 비교해야함 어라 함수가 하나 더 필요함
        minDifference(startTeam, linkTeam);
    }
    //
    public void minDifference(int startSum, int linkSum) {
        int difference = 0;
        if(startSum > linkSum)
            difference = startSum - linkSum;
        else
            difference = linkSum - startSum;

        if(difference < minDiff) {
            minDiff = difference;
        }
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Solution solution = new Solution(map);
        solution.finalTeam();
    }
}