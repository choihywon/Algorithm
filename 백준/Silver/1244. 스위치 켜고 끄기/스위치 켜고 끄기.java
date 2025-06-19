import java.io.*;
import java.util.*;

public class Main {
    static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); 
        switches = new int[n + 1]; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                manCheck(num, n);
            } else {
                womanCheck(num, n);
            }
        }


        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }

    static void manCheck(int num, int n) {
        for (int i = num; i <= n; i += num) {
            switches[i] = 1 - switches[i]; 
        }
    }

    static void womanCheck(int num, int n) {
        int left = num - 1;
        int right = num + 1;

        while (left >= 1 && right <= n && switches[left] == switches[right]) {
            left--;
            right++;
        }

        for (int i = left + 1; i <= right - 1; i++) {
            switches[i] = 1 - switches[i];
        }
    }
}
