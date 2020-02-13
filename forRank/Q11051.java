package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dp[][] = new int[N + 1][N + 1];
		
		dp[0][0] = 1;	//파스칼의 삼각형 꼭대기
		
		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;	//왼쪽 끝
			dp[i][i] = 1;	//오른쪽 끝
			for (int j = 1; j < i; j++)
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
		}		
		bw.write(dp[N][K] + "\n");
		
		br.close();
		bw.close();
	}
}
