package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q15923 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N + 1][2];
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		arr[N] = arr[0];
		
		for (int i = 0; i < N; i++) {
			int cur[] = arr[i];
			int next[] = arr[i + 1];
			
			if(cur[0] == next[0])
				total += Math.abs(cur[1] - next[1]);
			else if(cur[1] == next[1])
				total += Math.abs(cur[0] - next[0]);
		}
		
		bw.write(total + "\n");
		
		
		br.close();
		bw.close();
	}
}
