package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1010 {
	private static final int SIZE = 30;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int dp[][] = new int[SIZE][SIZE];
		
		for (int i = 0; i < SIZE; i++)
			dp[1][i] = i;
		
		for (int i = 2; i < SIZE; i++) {
			for (int j = i; j < SIZE; j++) {
				for (int k = 0; k < j - i + 1; k++) {
					dp[i][j] += dp[i - 1][j - k - 1];
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			bw.write(dp[N][M] + "\n");
		}
		
		br.close();
		bw.close();
	}
}
