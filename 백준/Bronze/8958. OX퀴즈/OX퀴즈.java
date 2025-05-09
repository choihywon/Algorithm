import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++) {
            String line = br.readLine();
            int score = 0;
            int connect = 0;
            for(int j = 0 ; j < line.length(); j++) {
                if(line.charAt(j) == 'O') {
                    connect++;
                    score = connect + score;
                }
                else {
                    connect = 0;
                }
            }
            System.out.println(score);

        }
    }

}