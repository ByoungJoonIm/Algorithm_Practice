package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2580 {
	private static final int SUDOKU_SIZE = 9;
	private static int[][] map;
	private static ArrayList<Point> points;
	
	private static class Point{
		int row;
		int col;
		int value;
		
		public Point(int row, int col, int value) {
			super();
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}
	
	private static boolean isCorrectValue(Point point){
		for (int i = 0; i < SUDOKU_SIZE; i++) {
			if(i != point.row && map[i][point.col] == point.value)
				return false;
			if(i != point.col && map[point.row][i] == point.value)
				return false;
		}
		
		int startRow = point.row / 3 * 3;
		int startCol = point.col / 3 * 3;
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if((i != point.row && j != point.col) && map[i][j] == point.value)
					return false;
			}
		}
		return true;
	}
	
	private static void dfs(int index) throws IOException{
		if(index == points.size()){
			printAll();
			System.exit(0);
		}
		
		Point cur = points.get(index);
		for (int i = 1; i <= SUDOKU_SIZE; i++) {
			if(isCorrectValue(new Point(cur.row, cur.col, i))){
				map[cur.row][cur.col] = i;
				dfs(index + 1);
				map[cur.row][cur.col] = 0;
			}
		}
	}
	
	private static void printAll() throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < SUDOKU_SIZE; i++) {
			for (int j = 0; j < SUDOKU_SIZE; j++)
				bw.write(map[i][j] + " ");
			bw.write("\n");
		}
		bw.close();	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[SUDOKU_SIZE][SUDOKU_SIZE];
		points = new ArrayList<Point>();
		StringTokenizer st;
		
		for (int i = 0; i < SUDOKU_SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SUDOKU_SIZE; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					points.add(new Point(i, j, map[i][j]));
			}
		}
		br.close();
		
		dfs(0);
	}
}