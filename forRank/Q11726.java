package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11726 {
	private static int getCase(int n){
		if(n < 2)
			return 1;
		
		int dp[] = new int[n + 1];
		dp[0] = dp[1] = 1;
		
		for (int i = 2; i <= n; i++)
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		
		return dp[n];
	}

	private static int getCase2(int n){
		int previous = 1;	//0
		int cur = 1;		//1
		
		for (int i = 0; i < n - 1; i++) {
			int temp = cur;
			cur = (cur + previous) % 10007;
			previous = temp;
		}
		
		return cur;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		bw.write(getCase2(n) + "\n");
		
		br.close();
		bw.close();
	}
}
