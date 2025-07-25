import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[n];
        StringTokenizer st =  new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ans);
        int sum = 0;
        int add = 0;  
        for (int i = 0; i < n; i++) {
            add += ans[i];
            sum += add;
        }
        System.out.print(sum);
    }
}