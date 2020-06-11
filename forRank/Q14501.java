package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14501 {
	private static void solution1() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N  = Integer.parseInt(br.readLine());
		int T[] = new int[N + 1];
		int P[] = new int[N + 1];
		int dp[] = new int[N + 2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}		
		
		for (int i = N; i > 0; i--) {
			int day = i + T[i];
			
			if(day <= N + 1){
				dp[i] = Math.max(P[i] + dp[day], dp[i + 1]);
			} else
				dp[i] = dp[i + 1];
		}
		
		bw.write(dp[1] + "\n");
		
		br.close();
		bw.close();

	}
	
	private static void solution2() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int T[] = new int[N + 1];
		int P[] = new int[N + 1];
		int dp[] = new int[N + 2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxValue = 0;
		
		for (int i = 1; i <= N; i++) {
			int nextDay = i + T[i];
			maxValue = Math.max(maxValue, dp[i]);
			dp[i] = maxValue;
			
			if(nextDay <= N + 1){
				dp[nextDay] = Math.max(dp[nextDay], dp[i] + P[i]);
			}
		}
		
		bw.write(Math.max(maxValue, dp[N + 1]) + "\n");
		
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) throws IOException {
//		solution1();
		solution2();
	}
}
