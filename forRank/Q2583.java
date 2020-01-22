package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2583 {
	private static int M;	//max Row
	private static int N;	//max Col
	private static boolean visited[][];
	private static int rowAdder[] = {0, 1, 0, -1};
	private static int colAdder[] = {1, 0, -1, 0};
	private static int counter;
	
	private static ArrayList<Integer> getSolution(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]){
					counter = 1;
					visited[i][j] = true;
					dfs(i, j);
					al.add(counter);
				}
			}
		}
		
		Collections.sort(al);
		return al;
	}
	
	private static void dfs(int row, int col){
		for (int i = 0; i < 4; i++) {
			int nextRow = row + rowAdder[i];
			int nextCol = col + colAdder[i];
			
			if(nextRow >= 0 && nextCol >= 0 && nextRow < M && nextCol < N){
				if(!visited[nextRow][nextCol]){
					visited[nextRow][nextCol] = true;
					counter++;
					dfs(nextRow, nextCol);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	//y, row
		N = Integer.parseInt(st.nextToken());	//x, col
		int K = Integer.parseInt(st.nextToken());
		visited = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++)
					visited[y][x] = true;
			}
		}
		
		ArrayList<Integer> rs = getSolution();
		
		bw.write(rs.size() + "\n");
		for (int i = 0; i < rs.size(); i++)
			bw.write(rs.get(i) + " ");
		bw.write("\n");
		
		
		br.close();
		bw.close();
	}
}
