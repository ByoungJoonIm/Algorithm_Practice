package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q17626 {
	public static int getResult(int n){
		int dp[] = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			
			for (int j = 1; j * j <= i; j++)
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		bw.write(getResult(n) + "\n");
		
		br.close();
		bw.close();
	}
}
