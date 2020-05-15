package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10708 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int targets[] = new int[M];
		int scores[] = new int[N];

		for (int i = 0; i < M; i++)
			targets[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int plusScore = N;
			
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				
				if(targets[i] == cur){
					scores[j]++;
					plusScore--;
				}
			}
			
			scores[targets[i] - 1] += plusScore;
		}
		
		for (int i = 0; i < N; i++) {
			bw.write(scores[i] + "\n");
		}
		
		br.close();
		bw.close();
	}
}
