package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10870 {
	private static int fibo(int n){
		if(n < 2)
			return n;
		int preb = 0;
		int cur = 1;
		
		for (int i = 1; i < n; i++) {
			int temp = cur;
			cur = cur + preb;
			preb = temp;
		}
		
		return cur;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(fibo(Integer.parseInt(br.readLine())) + "\n");
		
		br.close();
		bw.close();
	}
}
