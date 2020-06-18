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

public class Q17144 {
	private static final int rowAdder[] = {1, 0, -1, 0};
	private static final int colAdder[] = {0, 1, 0, -1};
	
	private static int R, C, T;
	private static int map[][];
	private static int fresherRow = -1;	//
	
	private static class Adder{
		int row;
		int col;
		int value;
		
		public Adder(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
		
		public boolean isValid(){
			return row >= 0 && col >= 0 && row < R && col < C && map[row][col] != -1;
		}
	}
	
	private static void extension(){
		Queue<Adder> queue = new LinkedList<Adder>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int value = map[i][j] / 5;
				for (int k = 0; k < rowAdder.length; k++) {
					Adder adder = new Adder(i + rowAdder[k], j + colAdder[k], value);
					if(adder.isValid()){
						queue.add(adder);
						map[i][j] -= value;
					}
				}
			}
		}
		
		while(!queue.isEmpty()){
			Adder cur = queue.poll();
			map[cur.row][cur.col] += cur.value;
		}
	}
	
	private static void purify(){
		//up
		for (int i = fresherRow - 1; i > 0; i--)
			map[i][0] = map[i - 1][0];
		for (int i = 0; i < C - 1; i++)
			map[0][i] = map[0][i + 1];
		for (int i = 0; i < fresherRow; i++)
			map[i][C - 1] = map[i + 1][C - 1];
		for (int i = C - 1; i > 1; i--)
			map[fresherRow][i] = map[fresherRow][i - 1];
		map[fresherRow][1] = 0;
		
		//down
		for (int i = fresherRow + 2; i < R - 1; i++)
			map[i][0] = map[i + 1][0];
		for (int i = 0; i < C - 1; i++)
			map[R - 1][i] = map[R - 1][i + 1];
		for (int i = R - 1; i > fresherRow + 1; i--)
			map[i][C - 1] = map[i - 1][C - 1];
		for (int i = C - 1; i > 1; i--)
			map[fresherRow + 1][i] = map[fresherRow + 1][i - 1];
		map[fresherRow + 1][1] = 0;
	}
	
	private static void second(){
		extension();
		purify();
	}
	
	private static int getRest(){
		for (int i = 0; i < T; i++)
			second();
		
		int sum = 2;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		
		return sum;
	}
	
	private static void testPurify(){
		R = 7;
		C = 8;
		map = new int[R][C];
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], i + 1);
		}
		
		map[2][0] = -1;
		map[3][0] = -1;
		fresherRow = 2;
		
		for (int i = 0; i < 20; i++) {
			purify();
			printMap();
			System.out.println("----------------------");
		}
	}
	
	private static void testExtension(){
		R = 3;
		C = 3;
		map = new int[R][C];
		map[1][1] = 46;
		
		int tempMap[][] = {
				{0, 30, 7},
				{-1, 10, 0},
				{-1, 0, 20}
		};
		
		map = tempMap;
		
		extension();
		printMap();
	}
	
	private static void printMap(){
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1 && fresherRow < 0)
					fresherRow = i;
			}
		}
		
		bw.write(getRest() + "\n");
		
		br.close();
		bw.close();
	}
}
