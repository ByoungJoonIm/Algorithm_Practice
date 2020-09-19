package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1629 {
	private static int getResult(int A, int B, int C){
		long mult = A % C;
		long result = 1;
		long n = B;
		
		while(n > 0){
			if(n % 2 == 1)
				result = ((result % C) * (mult % C)) % C;
			mult = ((mult % C) * (mult % C)) % C;
			n /= 2;
		}
		
		return (int)result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		bw.write(getResult(A, B, C) + "\n");
		
		br.close();
		bw.close();
	}
}
