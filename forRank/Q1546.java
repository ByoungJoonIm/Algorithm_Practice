package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int scores[] = new int[N];
		int max = 0;
		double sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, scores[i]);
		}
		
		for (int i = 0; i < N; i++)
			sum += ((double)scores[i] / max * 100);
		
		bw.write((sum / N) + "\n");
		
		br.close();
		bw.close();
	}
}
