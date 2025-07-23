import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       int[] seq = new int[n];
       for (int i = 0 ; i < n; i++ ) {
            seq[i] = Integer.parseInt(br.readLine());
       }

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int current = 1;
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int target = seq[i];

            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}