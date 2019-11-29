package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2589 {
	private static int map[][];
	private static int row;
	private static int col;
	private static int rowi[] = {0, 1, 0, -1};
	private static int coli[] = {1, 0, -1, 0};
	
	private static class Node{
		int row;
		int col;
		
		public Node(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	/*
	 * return 해당 타일에서의 최단 경로중 가장 긴 것
	 * */
	private static int bfs(int srow, int scol){
		if(map[srow][scol] == 0)
			return -1;
		boolean visited[][] = new boolean[row][col];
		
		int localCount = -1;							//자기 자신은 제외
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(srow, scol));
		
		while(!queue.isEmpty()){
			int qsize = queue.size();
			for (int i = 0; i < qsize; i++) {
				Node temp = queue.poll();
				if(visited[temp.row][temp.col])
					continue;
				visited[temp.row][temp.col] = true;
				for (int j = 0; j < 4; j++) {
					int nextRow = temp.row + rowi[j];
					int nextCol = temp.col + coli[j];
					if(nextRow >= 0 && nextCol >= 0 && nextRow < row && nextCol < col){
						if(map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol])
							queue.add(new Node(nextRow, nextCol));
					}
				}
			}
			localCount++;
		}
		return localCount;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		int rs = 0;
		
		//inputs
		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				if(str.charAt(j) == 'L')
					map[i][j] = 1;
			}
		}
		
		//타일만큼 bfs 실행
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int bfsRs = bfs(i, j);
				rs = (rs < bfsRs) ? bfsRs : rs; 
			}
		}
		
		bw.write(rs + "\n");
		
		br.close();
		bw.close();
	}
}
