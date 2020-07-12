package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1992 {
	private static final int POWER_UNDER = 2;
	private static int map[][];
	private static StringBuilder sb;
	
	private static boolean isValid(int row, int col, int depth){
		int power = (int)Math.pow(POWER_UNDER, depth);
		int targetNumber = map[row][col];
		
		for (int i = row; i < row + power; i++) {
			for (int j = col; j < col + power; j++) {
				if(targetNumber != map[i][j])
					return false;
			}
		}
		
		return true;
	}
	
	private static void setSb(int row, int col, int depth){
		if(depth < 1){
			sb.append(map[row][col]);
		} else {
			if(isValid(row, col, depth)){
				sb.append(map[row][col]);
			} else {
				sb.append('(');
				int power = (int)Math.pow(POWER_UNDER, depth - 1);
				for (int i = 0; i < POWER_UNDER; i++) {
					for (int j = 0; j < POWER_UNDER; j++) {
						setSb(row + i * power, col + j * power, depth - 1);
					}
				}
				sb.append(')');
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		int temp = 1;
		int depth = 0;
		
		while(temp < N){
			temp = (int)Math.pow(POWER_UNDER, ++depth);
		}
		
		setSb(0, 0, depth);
		
		bw.write(sb.toString() + "\n");
		
		br.close();
		bw.close();
	}
}
