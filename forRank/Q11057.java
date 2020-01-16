package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int dp[][] = new int[10][n + 1];
		
		for (int i = 0; i < 10; i++)
			dp[i][0] = 1;
		for (int i = 1; i <= n; i++)
			dp[9][i] = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 8; j >= 0; j--)
				dp[j][i] = (dp[j + 1][i] + dp[j][i - 1]) % 10007;
		}
		
		bw.write(dp[0][n] + "\n");
		
		br.close();
		bw.close();
	}
}
