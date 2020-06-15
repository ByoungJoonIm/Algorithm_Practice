package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17822 {
	private static final int rowAdder[] = {0, 1, 0, -1};
	private static final int colAdder[] = {1, 0, -1, 0};
	
	private static int N, M, T;
	private static int map[][];
	
	private static void rotate(int number){	//시계방향 한번 회전
		int last = map[number][M - 1];
		
		for (int i = M - 1; i > 0; i--) {
			map[number][i] = map[number][i - 1];
		}
		
		map[number][0] = last;
	}
	
	private static void rotate(int number, int direction, int times){
		if(direction == 1){
			times = M - times;
		}
		
		for (int i = 0; i < times; i++) {
			rotate(number);
		}
	}
	
	private static boolean delete(int row, int col, boolean visited[][], int deleteNumber, boolean deleteFlag){
		visited[row][col] = true;
		
		for (int i = 0; i < rowAdder.length; i++) {
			int nextRow = row + rowAdder[i];
			int nextCol = (col + colAdder[i] + M) % M;
			
			if(nextRow >= 0 && nextRow < N){
				if(!visited[nextRow][nextCol]){
					if(map[nextRow][nextCol] == deleteNumber){
						deleteFlag = true;
						delete(nextRow, nextCol, visited, deleteNumber, deleteFlag);
					}					
				}
			}
		}
		
		if(deleteFlag)
			map[row][col] = 0;
		
		return deleteFlag;
	}
	
	private static boolean deleteSame(){
		boolean deleted = false;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0){
					if(delete(i, j, new boolean[N][M], map[i][j], false))
						deleted = true;
				}
			}
		}
		
		return deleted;
	}
	
	private static void adjust(){
		double average = getAverage();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0 && map[i][j] != average){
					map[i][j] = map[i][j] > average ? map[i][j] - 1 : map[i][j] + 1;
				}
			}
		}
	}
	
	private static double getAverage(){
		double sum = 0;
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 0){
					sum += map[i][j];
					cnt++;
				}
			}
		}
		
		if(cnt == 0)
			return 0;
		return sum / cnt;
	}
	
	private static int getSum(){
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
			}
		}
		
		return sum;
	}
	
	private static void printMap(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}
	
	private static void test(){
		printMap();
		deleteSame();
		printMap();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int times = Integer.parseInt(st.nextToken());

			for (int j = 1; j <= N; j++) {
				if(j % number == 0)
					rotate(j - 1, direction, times);
			}

			if(!deleteSame()){
				adjust();
			}
		}
		
		bw.write(getSum() + "\n");
		
		br.close();
		bw.close();
	}
}
