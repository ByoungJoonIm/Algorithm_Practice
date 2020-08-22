package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 *
	e s	1	2	3	4	5	6	7
	1	V				
	2	X	V			
	3	VV	X	V		
	4	XX	VV	X	V	
	5	VVV	XX	VV	X	V
	6	X3	V3	X2	V2	X	V
	7	V4	X3	V3	X2	V2	X	V
	X : 
 * */

public class Q10942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N + 1];
		boolean dp[][] = new boolean[N + 1][N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//대각선 셋팅
		for (int s = 1; s <= N; s++) {
			dp[s][s] = true;
		}
		
		//X 대각선 셋팅
		for (int s = 2; s <= N; s++) {
			dp[s][s - 1] = arr[s] == arr[s - 1];
		}
		
		//나머지 채우기
		for (int i = 2; i < N; i++) {
			for (int j = 1; i + j <= N && i - j > 0; j++) {
				dp[i + j][i - j] = dp[i + j - 1][i - j + 1] && arr[i + j] == arr[i - j];
				
			}
		}
		
		for (int i = 2; i < N; i++) {
			for (int j = 1; i + j <= N && i - j - 1 > 0; j++) {
				dp[i + j][i - j - 1] = dp[i + j - 1][i - j] && arr[i + j] == arr[i - j - 1];
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(dp[e][s])
				bw.write("1\n");
			else
				bw.write("0\n");
		}
		
		br.close();
		bw.close();
	}
}
