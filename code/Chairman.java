package mathmatics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Chairman {
	public static void main(String[] args) throws Exception {
		final int size = 14;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int d[][] = new int[size + 1][size + 1];
		
		for (int i = 1; i <= size; i++) {
			d[0][i] = i;
		}
		
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				d[i][j] = d[i][j-1] + d[i-1][j];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			bw.write(d[k][n] + "\n");	
		}
		
		br.close();
		bw.close();
	}

}
