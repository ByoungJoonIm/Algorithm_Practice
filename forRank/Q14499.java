package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14499 {
	private static final int rowAdder[] = {0, 0, 0, -1, 1};
	private static final int colAdder[] = {0, 1, -1, 0, 0};
	private static final int rolling[][] = {
			{0, 0, 0, 0},
			{1, 5, 3, 4},	//EAST
			{1, 4, 3, 5},	//WEST
			{1, 2, 3, 0},	//SOUTH(NORTH¿Í ¹Ù²Þ)
			{1, 0, 3, 2},	//NORTH
	};
	
	private static int N;
	private static int M;
	private static int map[][];
	private static int curRow;
	private static int curCol;
	
	private static class Dice{
		int side[];	//1 : ¹Ù´Ú¸é, 3: ÇÏ´Ã¸é
		
		public Dice(){
			side = new int[6];
		}
		
		public int roll(int direction){
			int nextRow = curRow + rowAdder[direction];
			int nextCol = curCol + colAdder[direction];
			
			if(nextRow >= 0 && nextCol >=0 && nextRow < N && nextCol < M){
				int temp = side[rolling[direction][0]];
				side[rolling[direction][0]] = side[rolling[direction][1]];
				side[rolling[direction][1]] = side[rolling[direction][2]];
				side[rolling[direction][2]] = side[rolling[direction][3]];
				side[rolling[direction][3]] = temp;

				if(map[nextRow][nextCol] == 0){
					map[nextRow][nextCol] = side[1];
				} else {
					side[1] = map[nextRow][nextCol];
					map[nextRow][nextCol] = 0;
				}
				
				curRow = nextRow;
				curCol = nextCol;
				return side[3];
			}
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		curRow = Integer.parseInt(st.nextToken());
		curCol = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Dice dice = new Dice();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			int rs = dice.roll(cmd);
			
			if(rs > -1){
				bw.write(rs + "\n");
			} 
		}
		
		br.close();
		bw.close();
	}
}
