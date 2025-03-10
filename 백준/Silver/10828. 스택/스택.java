import java.util.*;
import java.io.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int[] stack;
    static int size;

    public static void  push(int i) {
        stack[size] = i;
        size++;
    }

    public static int pop() {
        if(size ==0) {
            return -1;
        } else {
            int result = stack[size-1];
            stack[size-1] = 0;
            size--;
            return result;
        }
    }

    private static int top() {
        if(size ==0) {
            return -1;
        } else {
            return stack[size-1];
        }
    }

    private static int size() {
        return size;
    }

    private static int empty() {
        if(size == 0) {
            return 1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        stack = new int[t];
        for(int i =0;i<t;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;

            }
        }
        System.out.print(sb);

    }
}