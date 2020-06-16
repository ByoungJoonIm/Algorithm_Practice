package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16234 {
	private static final int MAX_VALUE = 1000;
	private static final int rowAdder[] = {0, 1, 0, -1};
	private static final int colAdder[] = {1, 0, -1, 0};
	private static final int openRowAdder[] = {0, 0, 0, -1};
	private static final int openColAdder[] = {0, 0, -1, 0};
	
	private static int map[][];
	private static int N;
	private static int L;
	private static int R;
	private static boolean visited[][];
	private static boolean opened[][][];
	
	private static class Point{
		int row;
		int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	private static int solve(){
		int counter = 0;
		boolean isRunning = true;
		
		while(true){
			//init
			isRunning = false;
			opened = new boolean[N + 2][N + 2][2];	//0 : right , 1 : down
			visited = new boolean[N + 1][N + 1];
			
			//open
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N ; j++) {
					for (int k = 0; k < 2; k++) {
						int dist = Math.abs(map[i][j] - map[i + rowAdder[k]][j + colAdder[k]]);
						if(L <= dist && dist <= R){
							opened[i][j][k] = true;
							isRunning = true;
						}
					}
				}
			}
			
			if(!isRunning)
				break;
			counter++;
			
			//avg
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(!visited[i][j]){
						visited[i][j] = true;
						
						int sum = 0;
						Queue<Point> queue = new LinkedList<Point>();
						Queue<Point> result = new LinkedList<Point>();
						queue.add(new Point(i, j));
						result.add(new Point(i, j));
						sum += map[i][j];
						
						while(!queue.isEmpty()){
							Point cur = queue.poll();
							
							for (int k = 0; k < rowAdder.length; k++) {
								if(opened[cur.row + openRowAdder[k]][cur.col + openColAdder[k]][k % 2]){
									int nextRow = cur.row + rowAdder[k];
									int nextCol = cur.col + colAdder[k];
									
									if(!visited[nextRow][nextCol]){
										visited[nextRow][nextCol] = true;
										queue.add(new Point(nextRow, nextCol));
										result.add(new Point(nextRow, nextCol));
										sum += map[nextRow][nextCol];
									}
								}
							}
						}
						
						int avg = sum / result.size();
						while(!result.isEmpty()){
							Point cur = result.poll();
							map[cur.row][cur.col] = avg;
						}			
					} 
				}
			}
		}
		
		return counter;
	}
	
	private static void printMap(){
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N + 2][N + 2];
		
		for (int i = 1; i <= N; i++){
			map[i][0] = MAX_VALUE;
			map[i][N + 1] = MAX_VALUE;
		}
		Arrays.fill(map[0], MAX_VALUE);
		Arrays.fill(map[N + 1], MAX_VALUE);
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(solve() + "\n");
		
		br.close();
		bw.close();
	}
}
