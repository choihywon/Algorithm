import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int a = (60*H+M) - 45;
        if( a < 0 )
            a += 1440;
        //24: 00 = 1440

        int alarmH = a / 60;
        int alarmM = a % 60;

        System.out.print(alarmH + " " + alarmM);




    }
}