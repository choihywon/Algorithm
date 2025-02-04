import java.io.*;
import java.util.*;

class Solution {
    private int N;
    private int[] numbers;
    private int[] operators;
    private Integer maxResult = null;  // 첫 번째 결과로 초기화
    private Integer minResult = null;  // 첫 번째 결과로 초기화

    public Solution(int N, int[] numbers, int[] operators) {
        this.N = N;
        this.numbers = numbers;
        this.operators = operators;
    }

    // 최댓값과 최솟값을 구하는 함수
    public void findMaxMin() {
        dfs(1, numbers[0]);
    }

    private void dfs(int index, int current) {
        if (index == N) {
            // 첫 번째 계산 결과라면 직접 할당
            if (maxResult == null || minResult == null) {
                maxResult = current;
                minResult = current;
            } else {
                if (current > maxResult) maxResult = current;
                if (current < minResult) minResult = current;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                int nextValue = numbers[index];
                int newResult = current;

                if (i == 0) newResult += nextValue;
                else if (i == 1) newResult -= nextValue;
                else if (i == 2) newResult *= nextValue;
                else { // 나눗셈 처리
                    if (newResult < 0) {
                        newResult = -(-newResult / nextValue);
                    } else {
                        newResult /= nextValue;
                    }
                }

                dfs(index + 1, newResult);
                operators[i]++; // 백트래킹 (연산자 개수 복구)
            }
        }
    }

    public int getMaxResult() {
        return maxResult;
    }

    public int getMinResult() {
        return minResult;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        Solution solution = new Solution(N, numbers, operators);
        solution.findMaxMin();

        System.out.println(solution.getMaxResult());
        System.out.println(solution.getMinResult());
    }
}
