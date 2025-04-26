import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int[] arr= new int[42];
        Arrays.fill(arr,0);
        for(int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            if(arr[n%42] > 0)
                continue;
            arr[n%42]++;
            cnt++;
        }

        System.out.println(cnt);
    }
}