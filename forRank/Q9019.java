package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9019 {
	private static final int MAX_VALUE = 10000;
	private static final char COMMAND[] = {'D', 'S', 'L', 'R'};
	private static int map[][];
	
	private static int dispatch(int value, char command){
		switch(command){
		case 'D':
			return map[0][value];
		case 'S':
			return map[1][value];
		case 'L':
			return map[2][value];
		case 'R':
			return map[3][value];
		}
		return -1;
	}
	
	private static String getResult(int register, int target){
		boolean visited[] = new boolean[MAX_VALUE];
		int preValue[] = new int[MAX_VALUE];
		char preCmd[] = new char[MAX_VALUE];
		
		preValue[register] = -1;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[register] = true;
		queue.add(register);
		
		while(!queue.isEmpty()){
			int cur = queue.poll();
			
			for (int j = 0; j < COMMAND.length; j++) {
				int value = dispatch(cur, COMMAND[j]);
				
				if(!visited[value]){
					preValue[value] = cur;
					preCmd[value] = COMMAND[j];
					if(value == target){
						StringBuilder sb = new StringBuilder();
						sb.append(preCmd[value]);
						int v = preValue[value];
						
						while(preValue[v] != -1){
							sb.append(preCmd[v]);
							v = preValue[v];
						}
						return sb.reverse().toString();
					}
						
					visited[value] = true;
					queue.add(value);
				}
				
			}
		}
		return "";
	}
	
	private static void initMap(){
		for (int i = 0; i < MAX_VALUE; i++) {	//D
			map[0][i] = i * 2 % MAX_VALUE;
		}
		
		map[1][0] = MAX_VALUE - 1;
		for (int i = 1; i < MAX_VALUE; i++) {	//S
			map[1][i] = i - 1;
		}
		
		for (int i = 1; i < MAX_VALUE; i++) {
			int d1 = i / 1000;
			int d2 = i / 100 % 10;
			int d3 = i / 10 % 10;
			int d4 = i % 10;
			//L
			map[2][i] = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
			//R
			map[3][i] = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		map = new int[4][MAX_VALUE];
		initMap();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int register = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			bw.write(getResult(register, target) + "\n");
		}
		
		br.close();
		bw.close();
	}
}