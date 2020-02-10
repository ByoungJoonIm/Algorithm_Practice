package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N + 1];
		int d[] = new int[N + 1];
		int maxValue = -1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			d[i] = A[i];
			for (int j = 1; j < i; j++) {
				if(A[i] > A[j] && d[j] + A[i] > d[i])
					d[i] = d[j] + A[i];
			}
			maxValue = Math.max(maxValue, d[i]);
		}
		
		bw.write(maxValue + "\n");
		
		br.close();
		bw.close();
	}
}
