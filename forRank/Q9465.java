package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int score[][];
		int dp[][];
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			score = new int[2][n + 1];
			dp = new int[2][n + 1];
			
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= n; k++)
					score[j][k] = Integer.parseInt(st.nextToken());
			}

			dp[0][1] = score[0][1];
			dp[1][1] = score[1][1];
			
			for (int j = 2; j <= n; j++) {
				for (int k = 0; k < 2; k++)
					dp[k][j] = Math.max(dp[(k + 1) % 2][j - 1], dp[(k + 1) % 2][j - 2]) + score[k][j];
			}
			
			bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
