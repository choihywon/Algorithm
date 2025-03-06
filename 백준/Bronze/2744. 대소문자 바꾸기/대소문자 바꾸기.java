import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        for(char c : str.toCharArray()) {
            if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));        
            }
            else if(Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            }
            else {
                sb.append(c);
            }
        }
        
        System.out.println(sb.toString());

    }
}
