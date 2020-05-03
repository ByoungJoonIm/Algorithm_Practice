package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2033 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int unit = 10;
		
		while(N > unit){
			int remain = N % unit;
			N = N / unit;
			
			if( remain /(unit / 10) >= 5)
				N++;
			N*= unit;
			unit *= 10;
		}
		
		bw.write(N + "\n");
		
		br.close();
		bw.close();
	}
}
