package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2607 {
	public static void main(String[] args) throws IOException {
		final int ALPHALEN = 26;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int hist[][] = new int[N][ALPHALEN];
		int lens[] = new int[N];
		int total = 0;
		
		//inputs and hash calc
		for (int i = 0; i < N; i++){
			String str = br.readLine();
			lens[i] = str.length();
			for (int j = 0; j < lens[i]; j++) {
				hist[i][str.charAt(j) - 'A']++;
			}
		}
		
		for (int i = 1; i < hist.length; i++) {
			int subTotal = 0;
			if(Math.abs(lens[0] - lens[i]) < 2){
				for (int j = 0; j < ALPHALEN; j++)
					subTotal += Math.abs(hist[0][j] - hist[i][j]);
				if(subTotal < 3)
					total++;	
			}
		}
		
		bw.write(total + "\n");
		
		br.close();
		bw.close();
	}
}
