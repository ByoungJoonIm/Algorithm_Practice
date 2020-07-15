package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2630 {
	private static final int POWER_UNDER = 2;
	private static int map[][];
	private static int counter[];
	
	private static boolean isValid(int row, int col, int depth){
		int targetNumber = map[row][col];
		int power = (int)Math.pow(POWER_UNDER, depth);
		
		for (int i = row; i < row + power; i++) {
			for (int j = col; j < col + power; j++) {
				if(targetNumber != map[i][j])
					return false;
			}
		}
		
		return true;
	}
	
	private static void setCount(int row, int col, int depth){
		if(depth < 1){
			counter[map[row][col]]++;
			return;
		}
		
		if(isValid(row, col, depth)){
			counter[map[row][col]]++;
		} else {
			int power = (int)Math.pow(POWER_UNDER, depth - 1);
			
			for (int i = 0; i < POWER_UNDER; i++) {
				for (int j = 0; j < POWER_UNDER; j++) {
					setCount(row + i * power, col + j * power, depth - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		counter = new int[POWER_UNDER];
		
		int temp = 1;
		int depth = 0;
		
		while(temp < N)
			temp = (int)Math.pow(POWER_UNDER, ++depth);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		setCount(0, 0, depth);
		
		bw.write(counter[0] + "\n");
		bw.write(counter[1] + "\n");
		
		br.close();
		bw.close();
	}
}
