import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //참가자 수
        int n = Integer.parseInt(br.readLine());
        //사이즈
        int[] size = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        //티셔츠 묶음 수
        int T = Integer.parseInt(st.nextToken());
        // 펜 묶음 수
        int P = Integer.parseInt(st.nextToken());

        int stock = 0;
        for(int i = 0 ; i < 6; i++) {
            stock += (size[i] + T - 1) / T;
        }
        int penDass = n / P;
        int penSingle = n % P;

        System.out.println(stock);
        System.out.println(penDass + " " + penSingle);
    }
}