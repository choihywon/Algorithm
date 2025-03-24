import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        if (min < 45) {
            hour--;
            min += 60 - 45;
            if (hour < 0) {
                hour = 23;
            }
            System.out.print(hour + " " + min);
        } else {
            min -= 45;
            System.out.print(hour + " " + min);
        }
    }
}