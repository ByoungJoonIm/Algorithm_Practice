package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean isPrime[] = new boolean[N + 1];
		
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		
		for (int i = 2; i * i <= N; i++) {
			for (int j = i * 2; j <= N; j+=i)
				isPrime[j] = false;
		}
		
		for (int i = M; i <= N; i++) {
			if(isPrime[i])
				bw.write(i + "\n");
		}
		
		br.close();
		bw.close();
	}
}
