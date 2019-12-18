package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int weights[] = new int[N];
		int heights[] = new int[N];
		int ranks[] = new int[N];
		
		Arrays.fill(ranks, 1);
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(weights[i] > weights[j] && heights[i] > heights[j])
					ranks[j]++;
			}
		}
		
		for (int i = 0; i < N; i++)
			bw.write(ranks[i] + " ");
		
		br.close();
		bw.close();
	}
}
