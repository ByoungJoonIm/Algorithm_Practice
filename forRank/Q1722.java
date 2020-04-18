package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * fail
 * */

public class Q1722 {
	private static int N;
	private static int sequence = 0;
	private static boolean isRunning = true;
	
	private static boolean isSame(int[] arr1, int[] arr2){
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
	
	private static void find(boolean visited[], int order[], int depth, int targetSequence, int targetOrder[]){
		if(N == depth){
			sequence++;
			if(sequence == targetSequence)
				isRunning = false;
			if(targetSequence == -1){
				if(isSame(order, targetOrder))
					isRunning = false;
			}
			return;
		}
			
		for (int i = 0; i < N; i++) {
			if(!visited[i]){
				visited[i] = true;
				order[depth] = i + 1;
				find(visited, order, depth + 1, targetSequence, targetOrder);
				if(!isRunning)
					return;
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int subNumber = Integer.parseInt(st.nextToken());
		int targetSequence = -1;
		int targetOrder[] = {};
		boolean visited[] = new boolean[N];
		int order[] = new int[N];
		
		if(subNumber == 1){
			targetSequence = Integer.parseInt(st.nextToken());
			find(visited, order, 0, targetSequence, targetOrder);
			for (int i = 0; i < N; i++)
				bw.write(order[i] + " ");
			bw.write("\n");
		} else if (subNumber == 2){
			targetOrder = new int[N];
			for (int i = 0; i < N; i++)
				targetOrder[i] = Integer.parseInt(st.nextToken());
			find(visited, order, 0, targetSequence, targetOrder);
			bw.write(sequence + "\n");
		}
		
		
		br.close();
		bw.close();
	}
}
