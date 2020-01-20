package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11050 {
	private static int fact[];
	
	private static void fillFact(int N){
		fact[0] = 1;
		for (int i = 1; i <= N; i++) {
			fact[i] = fact[i - 1] * i;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		fact = new int[N + 1];
		fillFact(N);
		
		bw.write(String.format("%d\n", fact[N] / (fact[K] * fact[N - K])));
		
		br.close();
		bw.close();
	}
}
