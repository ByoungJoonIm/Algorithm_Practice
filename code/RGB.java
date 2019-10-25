package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int d[][] = new int[N + 1][3];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int rgb[] = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			for (int j = 0; j < 3; j++)
				d[i][j] = Math.min(d[i - 1][(j + 1) % 3], d[i - 1][(j + 2) % 3]) + rgb[j];
		}
		
		int min = d[N][0];
		for (int i = 1; i < 3; i++) {
			if(d[N][i] < min)
				min = d[N][i];
		}
		
		System.out.println(min);
	}
}