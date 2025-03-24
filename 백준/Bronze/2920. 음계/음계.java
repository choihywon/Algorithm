import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < 7; i++) {
            if (arr[i] < arr[i + 1]) {
                descending = false;
            } else if (arr[i] > arr[i + 1]) {
                ascending = false;
            }
        }

        if (ascending) {
            System.out.println("ascending");
        } 
        else if (descending) {
            System.out.println("descending");
        } 
        else {
            System.out.println("mixed");
        }
        
    }
}