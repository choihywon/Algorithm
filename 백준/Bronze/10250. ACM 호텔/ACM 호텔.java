import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //세글자면 yxx 세글자일땐 층 하나만 추출
        //네글자면 yyxx
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            //7번재인 경우 - 2층 1번

            int floor;
            int room;
            if(N % H == 0) {
                floor = H;
                room = N / H;
            }
            else {
                floor = N % H;
                room = N / H + 1;
            }
            System.out.println(floor * 100 + room);
        }

    }
}