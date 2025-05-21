import java.io.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		
		BigInteger N = new BigInteger(S, 2);
		
	
		String result = N.toString(8);
		
		System.out.println(result);
	}

}