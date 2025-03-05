import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int[] freq = new int[26]; 

        
        for (char c : str.toCharArray()) {
            freq[c - 'A']++; 
        }

        
        int maxCount = 0;
        char maxChar = '?';

        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                maxChar = (char) (i + 'A');
            } else if (freq[i] == maxCount) {
                maxChar = '?'; 
            }
        }

        System.out.println(maxChar);
    }
}
