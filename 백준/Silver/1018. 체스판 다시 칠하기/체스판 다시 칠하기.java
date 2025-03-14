import java.util.*;
import java.io.*;



public class Main {
    private static int solution(char[][] board, int startX, int startY) {
        int repaintB = 0;
        int repaintW = 0;
        char[] colors = {'B', 'W'};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                char expectedColorB = colors[(i + j) % 2];
                char expectedColorW = colors[(i + j + 1) % 2];

                if (board[startX + i][startY + j] != expectedColorB)
                    repaintB++;
                if (board[startX + i][startY + j] != expectedColorW)
                    repaintW++;
            }
        }

        return Math.min(repaintB, repaintW);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];

        for(int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minCount = Integer.MAX_VALUE;
        for(int i = 0 ; i <= n - 8; i++) {
            for(int j = 0 ; j <= m - 8 ; j++) {
                minCount = Math.min(minCount, solution(board,i,j));
            }
        }
        System.out.println(minCount);
    }
}