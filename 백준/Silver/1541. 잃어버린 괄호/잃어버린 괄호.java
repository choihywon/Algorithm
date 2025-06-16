import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minusParts = br.readLine().split("-");

        int result = 0;

        for (int i = 0; i < minusParts.length; i++) {
            int sum = 0;
            String[] plusParts = minusParts[i].split("\\+");

            for (String numStr : plusParts) {
                sum += Integer.parseInt(numStr);
            }

            if (i == 0) {
                result += sum;  
            } else {
                result -= sum;  
            }
        }

        System.out.println(result);
    }
}
