package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q5624 {
	private static final int UNIT = 100000;
	private static final int MAX_VALUE = UNIT * 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int numbers[] = new int[N];
		int counter = 0;
		boolean visited[] = new boolean[MAX_VALUE * 2 + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < i; j++) {
				if(visited[numbers[i] - numbers[j] + MAX_VALUE]){
					counter++;
					break;
				}
			}
			for (int j = 0; j <= i; j++)
				visited[numbers[i] + numbers[j] + MAX_VALUE] = true;
		}
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
