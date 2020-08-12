package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Q16929 {
	private static final int rowAdder[] = {0, 0, 1, -1};
	private static final int colAdder[] = {1, -1, 0, 0};
	private static final int HASH_MAGIC_NUMBER = 100;
	
	private static int R, C;
	private static char map[][];
	
	private static boolean isPossible = false;
	
	private static int encode(int point[]){
		return point[0] * HASH_MAGIC_NUMBER + point[1];
	}
	
	private static boolean getResult(){
		HashSet<Integer> visited = new HashSet<Integer>();
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				int cur[] = new int[] {i, j};
				if(!visited.contains(encode(cur))){
					HashSet<Integer> subVisited = new HashSet<Integer>();
		
					dfs(cur, cur, map[i][j], subVisited);
					
					if(isPossible)
						return true;
					visited.addAll(subVisited);
				}
			}
		}
		
		return false;
	}
	
	private static void dfs(int cur[], int prev[], char color, HashSet<Integer> hs){
		int hashValue = encode(cur);
		if(hs.contains(hashValue)){
			isPossible = true;
			return;
		}
		
		hs.add(hashValue);
		
		for (int i = 0; i < rowAdder.length; i++) {
			int next[] = {cur[0] + rowAdder[i], cur[1] + colAdder[i]};
			
			if(!Arrays.equals(next, prev)){				//왔던 방향으로는 진행 안함
				if(map[next[0]][next[1]] == color){
					dfs(next, cur, color, hs);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R + 2][C + 2];
		Arrays.fill(map[0], ' ');
		Arrays.fill(map[R + 1], ' ');
		for (int i = 1; i <= R; i++) {
			map[i][0] = ' ';
			map[i][C + 1] = ' ';
		}
		
		for (int i = 1; i <= R; i++) {
			String line = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}
		
		if(getResult()){
			bw.write("Yes\n");
		} else {
			bw.write("No\n");
		}
		
		br.close();
		bw.close();
	}
}
