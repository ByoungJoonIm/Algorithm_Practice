package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle {
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int d[][] = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			d[i][0] = d[i - 1][0] + Integer.parseInt(st.nextToken());
			for (int j = 1; j < i; j++)
				d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + Integer.parseInt(st.nextToken());
		}
		
		int max = d[0][0];	
		for (int i = 1; i <= N; i++) {
			if(d[N][i] > max)
				max = d[N][i];
		}
		
		System.out.println(max);
	}
}