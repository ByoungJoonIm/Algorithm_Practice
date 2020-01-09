package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2591 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String number = br.readLine();
		int len = number.length();
		int numbers[] = new int[len + 1];
		int dp[] = new int[len + 1];
		
		dp[0] = 1;
		for (int i = 1; i <= len; i++) {
			numbers[i] = number.charAt(i - 1) - '0';
			
			if(numbers[i] > 0) dp[i] += dp[i - 1];
			if(numbers[i] + numbers[i - 1] * 10 >= 10 && numbers[i] + numbers[i - 1] * 10 <= 34) dp[i] += dp[i - 2];
		}
		
		bw.write(dp[len] + "\n");
		
		br.close();
		bw.close();
	}
}
