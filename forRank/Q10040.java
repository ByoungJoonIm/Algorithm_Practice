package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10040 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cost[] = new int[N];
		int scores[] = new int[N];

		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			int limit = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < N; j++) {
				if(cost[j] <= limit){
					scores[j]++;
					break;
				}
			}
		}

		int maxIndex = 0;
		for (int i = 0; i < N; i++) {
			if(scores[i] > scores[maxIndex])
				maxIndex = i;
		}
		
		bw.write(maxIndex + 1 + "\n");
		
		br.close();
		bw.close();
	}
}
