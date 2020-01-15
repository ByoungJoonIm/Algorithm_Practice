package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int value[] = new int[N + 1];
		int dp[][] = new int[N + 1][N + 1];
		int dp2[] = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			value[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {		//2차원 배열을 사용한 경우
			for (int j = 1; j <= N; j++) {
				if(i > j){
					dp[i][j] = dp[i - 1][j];
				} else {
					if(dp[i - 1][j] < dp[i][j - i] + value[i])
						dp[i][j] = dp[i][j - i] + value[i];
					else
						dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {		//1차원 배열을 사용한 경우
			for (int j = i; j <= N; j++) {
				if(dp2[j] < dp2[j - i] + value[i])
					dp2[j] = dp2[j - i] + value[i];
			}
		}

		bw.write(dp2[N] + "\n");
		
		br.close();
		bw.close();
	}
}
