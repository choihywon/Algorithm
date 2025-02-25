import java.io.*;
import java.util.*;

class Solution {
    public void solution(int n, BufferedReader br) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int value : list) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Solution solution = new Solution();
        solution.solution(n, br);
    }
}
