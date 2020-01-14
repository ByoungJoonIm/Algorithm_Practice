package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10872 {
	private static int factorial(int n){
		int fact = 1;
		for (int i = 2; i <= n; i++)
			fact *= i;
		
		return fact;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		bw.write(factorial(n) + "\n");
		
		br.close();
		bw.close();
	}
}
