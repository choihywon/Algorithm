import java.util.*;
import java.io.*;

class Solution {
    public void mergeSort(int[] num, int left, int right) {
        if(left == right) return;
        int mid = (left+right)/2;
        mergeSort(num, left, mid);
        mergeSort(num, mid+1, right);
        merge(num, left, mid, right);

    }
    public void merge(int[] num, int left, int mid, int right) {
        //오른쪽 길이
        int n1 = mid - left + 1;
        //왼쪽 길이
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];
        //오른쪽 배열 저장
        for(int i = 0; i < n1; i++)
            L[i] = num[left + i];
        //왼쪽 배열 저장
        for(int j = 0; j < n2; j++)
            R[j] = num[mid + 1 + j];

        //오른쪽 왼쪽 배열 인덱스
        int i = 0, j = 0;
        //원본배열 시작 인덱스
        int k = left;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                num[k] = L[i];
                i++;
            } else {
              num[k] = R[j];
              j++;
            }
            k++;
        }
        while(i < n1) {
            num[k] = L[i];
            i++;
            k++;
        }
        while(j < n2) {
            num[k] = R[j];
            j++;
            k++;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
           numbers[i] = Integer.parseInt(br.readLine());
        }
        Solution solution = new Solution();
        solution.mergeSort(numbers, 0, n-1);
        
        for(int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}