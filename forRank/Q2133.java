/*
3x2 = 3x2

3x4 = (3x2)*(3x2) + (3x0)*2
3x6 = (3x4)*(3x2) + (3x2)*2 + (3x0)*2
3x8 = (3x6)*(3x2) + (3x4)*2 + (3x2)*2 + (3x0)*2
3x10 = (3x8)*(3x2) + (3x6)*2 + (3x4)*2 + (3x2)*2 + (3x0)*2
 */
package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2133 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		if(N % 2 == 0){
			int dp[] = new int[N + 1];
			
			dp[0] = 1;
			dp[2] = 3;
			
			for (int i = 4; i <= N; i += 2) {
				dp[i] = dp[i - 2] * dp[2];
				for (int j = 4; j <= i; j += 2)
					dp[i] += dp[i - j] * 2;
			}
			
			bw.write(dp[N] + "\n");
		} else {
			bw.write("0\n");
		}
		
		br.close();
		bw.close();
	}
}
