package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2960 {
	private static int findNumber(int N, int K){
		int counter = 0;
		
		boolean visited[] = new boolean[N + 1];
		
		for (int i = 2; i <= N; i++) {
			if(!visited[i]){
				for (int j = i; j <= N; j += i) {
					if(!visited[j]){
						visited[j] = true;
						counter++;
						if(counter == K)
							return j;	
					}
				}	
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		bw.write(findNumber(N, K) + "\n");
		
		br.close();
		bw.close();
	}
}
