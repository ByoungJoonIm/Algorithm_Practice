package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14503 {
	private static final int rowAdder[] = {1, 0, -1, 0};
	private static final int colAdder[] = {0, 1, 0, -1};
	private static boolean visited[][];
	private static boolean map[][];
	private static int count;
	private static int M;
	private static int N;
	
	private static boolean isValid(int nextRow, int nextCol){
		return (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < M && map[nextRow][nextCol]);
	}
	
	private static void dfs(int row, int col, int direction, int cnt){
		if(cnt == 4){
			int nextDirection = (direction + 2) % 4;
			int nextRow = row + rowAdder[nextDirection];
			int nextCol = col + colAdder[nextDirection];
			
			if(isValid(nextRow, nextCol))
				dfs(nextRow, nextCol, direction, 0);
			return;
		}
		
		if(!visited[row][col]){
			visited[row][col] = true;
			count++;
			dfs(row, col, direction, 0);
		} else {
			int nextDirection = (direction + 3) % 4;
			int nextRow = row + rowAdder[nextDirection];
			int nextCol = col + colAdder[nextDirection];

			if(isValid(nextRow, nextCol) && !visited[nextRow][nextCol])
				dfs(nextRow, nextCol, nextDirection, 0);
			else
				dfs(row, col, nextDirection, cnt + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//inputs
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//세로 크기
		M = Integer.parseInt(st.nextToken());	//가로 크기
		
		st = new StringTokenizer(br.readLine());
		int rRow = N - 1 - Integer.parseInt(st.nextToken());
		int rCol = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		map = new boolean[N][M];
		count = 0;
		
		for (int i = N - 1; i >= 0; i--) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if(Integer.parseInt(st.nextToken()) == 0)
					map[i][j] = true;
			}
		}
		
		dfs(rRow, rCol, direction, 0);
		bw.write(count + "\n");
		
		br.close();
		bw.close();
	}
}
