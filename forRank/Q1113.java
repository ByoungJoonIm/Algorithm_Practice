package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1113 {
	private static final int rowAdder[] = {0, 0, 1, -1};
	private static final int colAdder[] = {1, -1, 0, 0};
	
	private static int R, C;
	private static int map[][];
	
	private static boolean dfs(int row, int col, int height, boolean visited[][]){
		if(map[row][col] == 0)
			return false;

		if(map[row][col] >= height)
			return true;

		if(visited[row][col])
			return true;
		else
			visited[row][col] = true;
		
		boolean result = true;
		for (int i = 0; i < rowAdder.length; i++) {
			int nextRow = row + rowAdder[i];
			int nextCol = col + colAdder[i];
			
			result = result && dfs(nextRow, nextCol, height, visited);
		}
		
		return result;
	}
	
	private static int getResult(){
		int result = 0;
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					if(map[j][k] < i && dfs(j, k, i, new boolean[R + 2][C + 2]))
						result++;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R + 2][C + 2];
		
		for (int i = 1; i <= R; i++) {
			String line = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}
		
		bw.write(getResult() + "\n");
		
		br.close();
		bw.close();
	}
}
