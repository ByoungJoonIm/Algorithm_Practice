package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14863 {
	private static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int values[][] = new int[N + 1][4];	//도보 이동시간, 도보 모금액, 자전거 이동시간, 자전거 모금액
		int dp[][] = new int[N + 1][K + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < values[0].length; j++)
				values[i][j] = Integer.parseInt(st.nextToken());
		}
				
		dp[1][values[1][0]] = values[1][1];
		dp[1][values[1][2]] = Math.max(dp[1][values[1][2]], values[1][3]);
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				if(dp[i - 1][j] > 0){
					int walkNextTime = j + values[i][0];
					if(walkNextTime <= K)
						dp[i][walkNextTime] = Math.max(dp[i][walkNextTime], dp[i - 1][j] + values[i][1]);
					int bicycleNextTime = j + values[i][2];
					if(bicycleNextTime <= K)
						dp[i][bicycleNextTime] = Math.max(dp[i][bicycleNextTime], dp[i - 1][j] + values[i][3]);
				}
			}
		}
		
		int maxValue = 0;
		
		for (int i = 0; i <= K; i++)
			maxValue = Math.max(maxValue, dp[N][i]);
		
		bw.write(maxValue + "\n");
		
		br.close();
		bw.close();
	}
}
