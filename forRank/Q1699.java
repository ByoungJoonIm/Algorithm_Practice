package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1699 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int sqrtN = (int)Math.sqrt(N);
		int dp[] = new int[N + 1];
		
		for (int i = 1; i <= N; i++) 
			dp[i] = i;
		
		for (int i = 2; i <= sqrtN; i++) {
			for (int j = 1; j <= N; j++) {
				if(i * i <= j && dp[j] > dp[j - i * i] + 1)
					dp[j] = dp[j - i * i] + 1;
			}
		}
		
		bw.write(dp[N] + "\n");
		
		br.close();
		bw.close();
	}
}
