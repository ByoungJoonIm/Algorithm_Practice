package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class ComplexNumber {
	private static boolean map[][];
	private static int N;
	private static int lr[] = {0, 1, 0, -1};
	private static int ud[] = {1, 0, -1, 0};
	private static int count;
	
	private static int checkComplexes(int i, int j){
		count = 0;
		DFS(i, j);
		return count;
	}
	
	private static void DFS(int i, int j){
		map[i][j] = false;
		count++;
		for (int k = 0; k < 4; k++) {
			if(i + ud[k] >= 0 && i + ud[k] < N && j + lr[k] >= 0 && j + lr[k] < N){
				if(map[i + ud[k]][j + lr[k]])
					DFS(i + ud[k], j + lr[k]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> complexes = new ArrayList<Integer>();
		
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = str.charAt(j) == '1';
		}
		
		/*
		 * algorithm
		 * */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++){
				if(map[i][j])
					complexes.add(checkComplexes(i, j));						
			}
		}
		
		Collections.sort(complexes);
		
		bw.write(complexes.size() + "\n");
		for (int i = 0; i < complexes.size(); i++)
			bw.write(complexes.get(i) + "\n");
		br.close();
		bw.close();
	}
}
