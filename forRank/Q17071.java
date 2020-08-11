package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17071 {
	private static final int END_LINE = 500000;
	private static int N, K;
	
	private static int getResult(){
		int time = 0;
		int target = K;
		Queue<Integer> queue = new LinkedList<Integer>();
		int visited[][] = new int[2][END_LINE + 1];
		
		Arrays.fill(visited[0], -1);
		Arrays.fill(visited[1], -1);
		
		queue.add(N);
		visited[0][N] = 0;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			time++;
			
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				
				int next[] = {cur - 1, cur + 1, cur * 2};
				
				
				for (int j = 0; j < next.length; j++) {
					if(0 <= next[j] && next[j] <= END_LINE && visited[time % 2][next[j]] == -1){
						queue.add(next[j]);
						visited[time % 2][next[j]] = time;
					}
				}
			}
		}
		
		int curTime = 0;
		
		while(target <= END_LINE){
			int findTime = visited[curTime % 2][target];
			if( -1 < findTime && findTime <= curTime){
				return curTime;
			}
			target += ++curTime;
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bw.write(getResult() + "\n");
		
		br.close();
		bw.close();
	}
}
