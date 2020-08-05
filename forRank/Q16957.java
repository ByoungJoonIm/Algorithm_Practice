package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Q16957 {
	private static final int rowAdder[] = {0, 0, 1, 1, 1, -1, -1, -1};
	private static final int colAdder[] = {1, -1, 1, 0, -1, 1, 0, -1};
	
	private static int R, C;
	private static int map[][];
	private static int result[][];
	private static Point preparedDirection[][];
	
	private static class Point{
		int row;
		int col;
		
		public Point(int row, int col){
			this.row = row;
			this.col = col;
		}
		
		public Point(Point p, int nextIndex){
			this.row = p.row + rowAdder[nextIndex];
			this.col = p.col + colAdder[nextIndex];
		}		
	}
	
	private static int getMinIndex(int row, int col){
		int index = 0;
		
		for (int i = 1; i < rowAdder.length; i++) {
			int nextRow = row + rowAdder[i];
			int nextCol = col + colAdder[i];
			
			if(map[nextRow][nextCol] < map[row + rowAdder[index]][col + colAdder[index]])
				index = i;
		}
		
		return (map[row][col] < map[row + rowAdder[index]][col + colAdder[index]]) ? -1 : index;
	}
	
	private static Point setDirection(Point p){
		if(preparedDirection[p.row][p.col] == null){
			int nextIndex = getMinIndex(p.row, p.col);
			
			if(nextIndex == -1)
				preparedDirection[p.row][p.col] = p;
			else {
				Point nextPoint = new Point(p, nextIndex);
				preparedDirection[p.row][p.col] = setDirection(nextPoint);
			}
		}
		return preparedDirection[p.row][p.col];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R + 2][C + 2];
		result = new int[R + 2][C + 2];
		preparedDirection = new Point[R + 2][C + 2];
		
		//fill Integer.MAX_VALUE for bound.
		Arrays.fill(map[0], Integer.MAX_VALUE);
		Arrays.fill(map[R + 1], Integer.MAX_VALUE);
		for (int i = 1; i <= R; i++) {
			map[i][0] = Integer.MAX_VALUE;
			map[i][C + 1] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//set preparedDirection
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				setDirection(new Point(i, j));
			}
		}
		
		//set result
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				Point dest = preparedDirection[i][j];
				result[dest.row][dest.col]++;
			}
		}
		
		//print result
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
