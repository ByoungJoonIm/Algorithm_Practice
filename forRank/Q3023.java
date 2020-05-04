package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q3023 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String paterns[] = new String[R];
		
		for (int i = 0; i < R; i++) {
			paterns[i] = br.readLine();
		}
		
		st = new StringTokenizer(br.readLine());
		int errorRow = Integer.parseInt(st.nextToken()) - 1;
		int errorCol = Integer.parseInt(st.nextToken()) - 1;
		
		for (int i = 0; i < 2 * R; i++) {
			for (int j = 0; j < 2 * C; j++) {
				int mappedRow = (i < R) ? i : 2 * R - 1 - i;
				int mappedCol = (j < C) ? j : 2 * C - 1 - j;
				
				if(i == errorRow && j == errorCol){
					if(paterns[mappedRow].charAt(mappedCol) == '#')
						bw.write(".");
					else
						bw.write("#");
				} else {
					bw.write(paterns[mappedRow].charAt(mappedCol));
				}
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
