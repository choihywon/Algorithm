import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double score[] = new double[n];
        double max = 0;


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) {
         score[i] = Double.parseDouble(st.nextToken());
         if(score[i] > max)
             max = score[i];

        }

        double sumScore = 0;
        for(int i = 0 ; i < n; i++) {
            sumScore = sumScore + (score[i]/max)*100;
        }

        double avg = 0;
        avg = sumScore/n;

        System.out.println(avg);
    }
}