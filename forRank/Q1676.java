package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1676 {
	private static int N;
	private static int cnt2;
	private static int cnt5;
	
	private static void addNumber(int n){
		while(n % 2 == 0){
			cnt2++;
			n /= 2;
		}
		
		while(n % 5 == 0){
			cnt5++;
			n /= 5;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		cnt2 = 0;
		cnt5 = 0;

		for (int i = 2; i <= N; i++)
			addNumber(i);
		
		bw.write(Math.min(cnt2, cnt5) + "\n");
		
		br.close();
		bw.close();
	}
}
