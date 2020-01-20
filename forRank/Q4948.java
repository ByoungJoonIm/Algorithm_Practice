package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q4948 {
	private static final int N_MAX = 123456;
	private static boolean primary[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		primary = new boolean[2 * N_MAX + 1];
		String input = null;
		
		Arrays.fill(primary, true);
		primary[1] = false;
		
		for (int i = 2; i * i <= N_MAX * 2; i++) {
			for (int j = i * 2; j <= N_MAX * 2; j += i)
				primary[j] = false;
		}
		
		while(true){
			input = br.readLine();
			int n = Integer.parseInt(input);
			
			if(n == 0)
				break;
			
			int cnt = 0;
			
			for (int i = n + 1; i <= 2 * n; i++) {
				if(primary[i])
					cnt++;
			}
			
			bw.write(cnt + "\n");
		}
		
		br.close();
		bw.close();
	}
}
