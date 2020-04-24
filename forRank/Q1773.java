package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());	//finish time
		
		boolean isExploded[] = new boolean[C + 1];
		int explosionTime = 0;
		for (int i = 0; i < N; i++) {
			int period = Integer.parseInt(br.readLine());
			
			if(!isExploded[period]){
				for (int j = period; j <= C; j += period){
					if(!isExploded[j]){
						isExploded[j] = true;
						explosionTime++;
					}
				}
			}
		}
		
		bw.write(explosionTime + "\n");
		
		br.close();
		bw.close();
	}
}
