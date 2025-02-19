import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] rank = new int[n];
        double[][] avgArray = new double[n][2];

        for (int i = 0; i < n; i++) {
            avgArray[i][0] = (score[i][0] + score[i][1]) / 2.0; 
            avgArray[i][1] = i; 
        }

        Arrays.sort(avgArray, (a, b) -> Double.compare(b[0], a[0])); 

        int currentRank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && avgArray[i][0] != avgArray[i - 1][0]) {
                currentRank = i + 1; 
            }
            rank[(int) avgArray[i][1]] = currentRank;
        }

        return rank;
    }
}
