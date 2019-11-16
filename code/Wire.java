package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wire {
	public static void main(String[] args) throws Exception {
		final int MAXWIRECOUNT = 500;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int A[] = new int[MAXWIRECOUNT];
		int d[] = new int[MAXWIRECOUNT];
		int N = Integer.parseInt(br.readLine());
		int maxLen = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < MAXWIRECOUNT; i++) {
			if(A[i] == 0)
				continue;
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if(A[i] > A[j] && d[i] < d[j] + 1)
					d[i] = d[j] + 1;
			}
			
			if(maxLen < d[i])
				maxLen = d[i];
		}
		
		System.out.println(N - maxLen);
		br.close();
	}
}
