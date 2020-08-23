package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1780 {
	private static final int POWER_UNDER = 3;
	private static int counters[];	//value + 1 == index
	private static int N;
	private static int map[][];
	
	//depth = 1 ~ 7
	private static boolean isValidPaper(int row, int col, int depth){
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
	
	private static void setResult(int row, int col, int depth){
		if(depth < 1){
			counters[map[row][col] + 1]++;
			return;
		}
			
		if(isValidPaper(row, col, depth)){
			counters[map[row][col] + 1]++;
		} else {
			int power = (int)Math.pow(POWER_UNDER, depth - 1);
			
			for (int i = 0; i < POWER_UNDER; i++) {
				for (int j = 0; j < POWER_UNDER; j++) {
					setResult(row + i * power, col + j * power, depth - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		counters = new int[POWER_UNDER];
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int depth = 1;
		int temp = POWER_UNDER;
		
		while(temp < N)
			temp = (int)Math.pow(POWER_UNDER, ++depth);
		
		setResult(0, 0, depth);
		
		for (int i = 0; i < counters.length; i++)
			bw.write(counters[i] + "\n");
		
		br.close();
		bw.close();
	}
}
