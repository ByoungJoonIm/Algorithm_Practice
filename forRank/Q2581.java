package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q2581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		boolean isPrime[] = new boolean[N + 1];
		int min = -1;
		int sum = 0;
		
		
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		
		for (int i = 2; i * i < N; i++) {
			for (int j = i * 2; j <= N; j += i) {
				isPrime[j] = false;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if(isPrime[i]){
				if(min == -1)
					min = i;
				sum += i;
			}
		}
		
		if(min == -1)
			bw.write("-1\n");
		else
			bw.write(String.format("%d\n%d\n", sum, min));
		
		br.close();
		bw.close();
	}
}
