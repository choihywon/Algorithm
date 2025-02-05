import java.io.*;
import java.util.*;

class Solution {
    public void sort(int[] numbers, int k) {
        for(int i = 0; i < k - 1; i++) {
            int min = i;
            for(int j = i + 1; j < k; j++) {
                if(numbers[j] < numbers[min]) {
                    min = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = temp;
        }



    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Solution solution = new Solution();
        solution.sort(num, n);
        for(int i = 0; i < n; i++){
            System.out.print(num[i] + " ");
        }
    }
}