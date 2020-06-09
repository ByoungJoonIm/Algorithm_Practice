package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q17837 {
	private static final int rowAdder[] = {0, 0, 0, -1, 1};
	private static final int colAdder[] = {0, 1, -1, 0, 0};
	private static final int WHITE = 0;
	private static final int RED = 1;
	private static final int BLUE = 2;
	
	private static int N, K;
	private static int map[][];
	private static LinkedList<Unit> unitMap[][];
	private static Unit units[];
	
	private static class Unit{
		int row;
		int col;
		int direction;
		int number;
		private static int counter = 0;
		
		public Unit(int row, int col, int direction) {
			this.row = row;
			this.col = col;
			this.direction = direction;
			this.number = ++counter;
		}
	}
	
	private static boolean move(){
		for (int i = 1; i <= K; i++) {
			Unit cur = units[i];
			
			int nextRow = cur.row + rowAdder[cur.direction];
			int nextCol = cur.col + colAdder[cur.direction];
			
			LinkedList<Unit> curList = unitMap[cur.row][cur.col];
			LinkedList<Unit> nextList = unitMap[nextRow][nextCol];
			
			int indexInList = curList.indexOf(cur);
			
			if(map[nextRow][nextCol] == WHITE){
				int size = curList.size();
				
				for (int j = 0; j < size - indexInList; j++) {
					Unit tempUnit = curList.remove(indexInList);
					tempUnit.row = nextRow;
					tempUnit.col = nextCol;
					nextList.add(tempUnit);
				}
				
			} else if(map[nextRow][nextCol] == RED){
				while(true){
					Unit tempUnit = curList.removeLast();
					tempUnit.row = nextRow;
					tempUnit.col = nextCol;
					nextList.add(tempUnit);
					
					if(tempUnit == cur)
						break;
				}
			} else if(map[nextRow][nextCol] == BLUE){
				cur.direction = cur.direction % 2 == 1 ? cur.direction + 1 : cur.direction - 1;
				nextRow = cur.row + rowAdder[cur.direction];
				nextCol = cur.col + colAdder[cur.direction];
				
				if(map[nextRow][nextCol] != BLUE)
					i--;
				continue;
			}
			
			if(nextList.size() >= 4)
				return true;
		}
		return false;
	}
	
	private static int getTurn(){
		int turn;
		
		for (turn = 1; turn <= 1000; turn++) {
			if(move())
				return turn;
		}
		
		return -1;
	}
	
	private static void test(){
		printUnitMap();
		move();
		printUnitMap();
		move();
		printUnitMap();
	}
	
	private static void printUnitMap(){
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(unitMap[i][j].size() > 0){
					System.out.print(i + ", " + j + " : " );
					for (int k = 0; k < unitMap[i][j].size(); k++) {
						System.out.print(unitMap[i][j].get(k).number + "(" + unitMap[i][j].get(k).direction + ") ");
					}
					System.out.println();
				}
			}
		}
		System.out.println("--------------------------");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 2][N + 2];
		units = new Unit[K + 1];
		unitMap = new LinkedList[N + 2][N + 2];
		
		Arrays.fill(map[0], BLUE);
		Arrays.fill(map[N + 1], BLUE);
		for (int i = 1; i <= N; i++) {
			map[i][0] = BLUE;
			map[i][N + 1] = BLUE;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				unitMap[i][j] = new LinkedList<Unit>();
			}
		}
		
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			units[i] = new Unit(row, col, direction);
			unitMap[row][col].add(units[i]);
		}
		
		bw.write(getTurn() + "\n");
		
		br.close();
		bw.close();
	}
}
