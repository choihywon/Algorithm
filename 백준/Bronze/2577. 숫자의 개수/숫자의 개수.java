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
        while (num > 0) {
            int digit = num % 10; 
            arr[digit]++;
            num /= 10; 
        }

        for(int i = 0; i<10; i++) {
            System.out.println(arr[i]);
        }
    }
}