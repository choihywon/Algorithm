import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            names[i] = s.substring(0,1) + s.substring(s.length()-1,s.length());
        }
        for(int i = 0 ; i < n ; i++) {
            System.out.println(names[i]);
        }

    }
}