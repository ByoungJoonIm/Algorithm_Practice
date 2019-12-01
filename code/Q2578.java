package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2578 {
	private static final int SIZE = 5;
	private static final int LINE = 3;
	private static int map[][] = new int[SIZE][SIZE];
	private static boolean visited[][] = new boolean[SIZE][SIZE];
	
	private static boolean isBingGo(){
		int lines = 0;
		
		for (int i = 0; i < SIZE; i++) {		//행, 열방향 체크
			boolean isLineRow = true;
			boolean isLineCol = true;
			for (int j = 0; j < SIZE; j++) {	
				if(!visited[i][j])
					isLineRow = false;
				if(!visited[j][i])
					isLineCol = false;
			}
			if(isLineRow)
				lines++;
			if(isLineCol)
				lines++;
		}
		
		boolean isLineDiag = true;
		boolean isLineRevDiag = true;
		
		for (int i = 0; i < SIZE; i++) {		//대각선 체크
			if(!visited[i][i])
				isLineDiag = false;
			if(!visited[i][SIZE - 1 - i])
				isLineRevDiag = false;
		}
		if(isLineDiag)
			lines++;
		if(isLineRevDiag)
			lines++;
		
		return lines >= LINE;
	}
	
	private static void mark(int value){
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(map[i][j] == value)
					visited[i][j] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//inputs
		for (int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= SIZE; j++) {
				mark(Integer.parseInt(st.nextToken()));
				if(i * SIZE + j >= SIZE * LINE - LINE){
					if(isBingGo()){
						bw.write((i * SIZE + j) + "\n");
						br.close();
						bw.close();
						return;
					}	
				}
			}
		}
	}
}
