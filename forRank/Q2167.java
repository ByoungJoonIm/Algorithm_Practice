package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2167 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken()) - 1;
			int sj = Integer.parseInt(st.nextToken()) - 1;
			int ei = Integer.parseInt(st.nextToken()) - 1;
			int ej = Integer.parseInt(st.nextToken()) - 1;
			
			int sum = 0;

			for (int j = si; j <= ei; j++) {
				for (int k = sj; k <= ej; k++)
					sum += arr[j][k];
			}
			
			bw.write(sum + "\n");
		}
		
		br.close();
		bw.close();
	}
}
