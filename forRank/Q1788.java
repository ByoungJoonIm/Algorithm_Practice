package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1788 {
	private static int getFibo(int n){
		if(n == 0)
			return 0;
		
		int a = 0;	//0Ç×
		int b = 1;	//1Ç×
		
		for (int i = 2; i <= Math.abs(n); i++) {
			int next = (a + b) % 1000000000;
			a = b;
			b = next;
		}
		
		if( n < 0 && n % 2 == 0)
			return -b;
		return b;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int rs = getFibo(n);
		int absRs = Math.abs(rs);
		
		if(rs == 0)
			bw.write("0\n");
		else
			bw.write(rs / absRs + "\n");
		
		bw.write(absRs + "\n");
		
		br.close();
		bw.close();
	}
}
