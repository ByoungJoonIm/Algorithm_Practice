package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int score[] = new int[N + 1];
		int dp[] = new int[N + 1];
		
		for (int i = 1; i <= N; i++)
			score[i] = Integer.parseInt(br.readLine());
		
		dp[1] = score[1];
		if(N > 1)
			dp[2] = score[2] + score[1];
		for (int i = 3; i <= N; i++)
			dp[i] = Math.max(dp[i-3] + score[i - 1] + score[i], dp[i - 2] + score[i]);
		
		bw.write(dp[N] + "\n");
		
		br.close();
		bw.close();
	}
}
