import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        int index = 0;
        int position = 0;
        for(int n : arr) {
            position++;
            if(n > max) {
                max = n;
                index = position;
            }
                
               
        }
        System.out.println(max);
        System.out.print(index);
    }
}