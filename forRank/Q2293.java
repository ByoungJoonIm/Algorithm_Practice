package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coins[] = new int[n + 1];
		int dp[] = new int[k + 1];
		
		for (int i = 1; i <= n; i++)
			coins[i] = Integer.parseInt(br.readLine());
		
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if(coins[i] <= j)
					dp[j] += dp[j - coins[i]];
			}
		}
		
		bw.write(dp[k] + "\n");
		
		br.close();
		bw.close();
	}
}
