package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11727 {
	private static int getCase(int n){
		int dp[] = new int[n + 1];
		
		dp[1] = 1;
		if(n < 2)
			return dp[1];
		dp[2] = 3;
		if(n < 3)
			return 3;
		
		for (int i = 3; i <= n; i++)
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		bw.write(getCase(n) + "\n");
		
		br.close();
		bw.close();
	}
}
