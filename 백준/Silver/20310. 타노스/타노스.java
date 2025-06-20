import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        int num0 = 0;

        int num1 = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sb.append(c);
            if(c == '0') num0++;
            else num1++;
        }

        num0 /= 2;
        num1 /= 2;

        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '1') {
                sb.setCharAt(i, '2');
                num1--;
            }
            if(num1 == 0) break;
        }

        for(int i = sb.length() - 1; i > -1; i--){
            if(sb.charAt(i) == '0') {
                sb.setCharAt(i, '2');
                num0--;
            }
            if(num0 == 0) break;
        }

        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '1' || sb.charAt(i) == '0') System.out.print(sb.charAt(i));
        }
    }
}