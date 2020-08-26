package forRank;

//너무 어렵게 풀었다...

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q12869 {
	private static final int SCV_MAX = 3;
	private static final int MUT_ATTACK[] = {1, 3, 9};

	private static int scvs[];
	private static int min;
	
	private static int getMeaningfull(int scvs[]){
		int count = 0;
		for (int i = 0; i < SCV_MAX; i++)
			if(scvs[i] > 0)
				count++;
		return count;
	}
	
	private static void dfs(int depth, int scvs[], int visited[][][]){
		int meaningfull = getMeaningfull(scvs);
		
		if(meaningfull == 0){
			min = Math.min(min, depth);
			return;
		}
		if(depth >= min)
			return;
		
		subDfs(0, meaningfull, new int[meaningfull], new boolean[SCV_MAX], scvs, depth, visited);
	}
	
	//오름차순으로 정렬되어있어야 의미 있음
	private static void subDfs(int subDepth, int meaningfull, int idx[], boolean subVisited[], int scvs[], int depth, int visited[][][]){
		if(subDepth == meaningfull){
			int newScvs[] = scvs.clone();

			for (int i = 0; i < idx.length; i++) {
				int index = SCV_MAX - 1 - i;
				newScvs[index] -= MUT_ATTACK[idx[i]];
				newScvs[index] = Math.max(newScvs[index], 0);
			}
			
			Arrays.sort(scvs);
			if(visited[newScvs[0]][newScvs[1]][newScvs[2]] == 0 || visited[newScvs[0]][newScvs[1]][newScvs[2]] > depth){
				visited[newScvs[0]][newScvs[1]][newScvs[2]] = depth;
				dfs(depth + 1, newScvs, visited);
			}
			return;
		}
			
		for (int i = SCV_MAX - 1; i >= SCV_MAX - meaningfull; i--) {
			if(!subVisited[i]){
				idx[meaningfull - subDepth - 1] = i;
				subVisited[i] = true;
				subDfs(subDepth + 1, meaningfull, idx, subVisited, scvs, depth, visited);
				idx[meaningfull - subDepth - 1] = 0;
				subVisited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		scvs = new int[SCV_MAX];
		min = Integer.MAX_VALUE;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			scvs[i] = Integer.parseInt(st.nextToken());
	
		Arrays.sort(scvs);
		dfs(0, scvs, new int[61][61][61]);
		bw.write(min + "\n");
		
		br.close();
		bw.close();
	}
}
