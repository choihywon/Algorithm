import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());

        int num = n1*n2*n3;
        String str = String.valueOf(num);
        int[] arr = new int[10];
        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            arr[digit]++;
        }

        for(int i = 0; i<10; i++) {
            System.out.println(arr[i]);
        }
    }
}