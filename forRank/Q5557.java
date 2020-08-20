package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q5557 {
	private static int MAX_VALUE = 20;
	
	private static int N;
	private static int arr[];
	
	private static boolean isRightBoundary(int value){
		return value >= 0 && value <= MAX_VALUE;
	}
	
	private static long getResult(){
		long dp[][] = new long[N][MAX_VALUE + 1];
		
		dp[1][arr[1]] = 1;
		
		for (int i = 1; i < N - 1; i++) {
			int next = arr[i + 1];
			
			for (int j = 0; j <= MAX_VALUE ; j++) {
				if(dp[i][j] > 0){
					if(isRightBoundary(j - next))
						dp[i + 1][j - next] += dp[i][j];
					if(isRightBoundary(j + next))
						dp[i + 1][j + next] += dp[i][j];
				}
			}
		}
		
		return dp[N - 1][arr[N]];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(getResult() + "\n");
		
		br.close();
		bw.close();
	}
}
