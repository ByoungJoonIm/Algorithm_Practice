package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2240 {
	private static final int START = 1;
	private static int T, W;
	
	private static int getResult(int arr[]){
		int result = 0;
		
		int dp[][] = new int[T + 1][W + 1];
		
		for (int t = 1; t <= T; t++) {
			dp[t][0] = arr[t] == START ? dp[t - 1][0] + 1 : dp[t - 1][0];
			for (int j = 1; j <= W; j++) {
				int subCur = j % 2 == 0 ? 1 : 2;

				dp[t][j] = Math.max(dp[t - 1][j - 1] + 1, subCur == arr[t] ? dp[t - 1][j] + 1 : dp[t - 1][j]);
				result = Math.max(result, dp[t][j]);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int arr[] = new int[T + 1];
		
		for (int i = 1; i <= T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		bw.write(getResult(arr) + "\n");
		
		br.close();
		bw.close();
	}
}
