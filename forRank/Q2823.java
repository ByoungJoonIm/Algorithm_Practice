package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2823 {
	private static final int rowAdder[] = {0, 1, 0, -1};
	private static final int colAdder[] = {1, 0, -1, 0};
	
	private static final char ROAD = '.';
	private static int R;
	private static int C;
	private static boolean map[][];
	
	private static boolean isPossible(int row, int col){
		int counter = 0;
		for (int i = 0; i < rowAdder.length; i++) {
			int nextRow = row + rowAdder[i];
			int nextCol = col + colAdder[i];
			
			if(nextRow >= 0 && nextCol >= 0 && nextRow < R && nextCol < C){
				if(map[nextRow][nextCol])
					counter++;
			}
		}
		return counter >= 2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				if(line.charAt(j) == ROAD){
					map[i][j] = true;
				}
			}
		}
		
		boolean possible = true;
		
		for (int i = 0; i < R && possible; i++) {
			for (int j = 0; j < C && possible; j++) {
				if(map[i][j])
					possible = isPossible(i, j);
			}
		}
		
		if(possible)
			bw.write("0\n");
		else
			bw.write("1\n");
		
		br.close();
		bw.close();
	}
}
