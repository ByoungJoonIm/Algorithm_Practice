package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q3078 {
	private static final int INIT_SIZE = 300000;
	private static final int MAX_LEN = 20;
	private static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> friends[] = new ArrayList[MAX_LEN + 1];
		
		for (int i = 1; i <= MAX_LEN; i++)
			friends[i] = new ArrayList<Integer>(INIT_SIZE);
		
		for (int i = 0; i < N; i++) {
			int nameLen = br.readLine().length();
			friends[nameLen].add(i);
		}
		
		for (int i = 1; i <= MAX_LEN; i++) {
			Collections.sort(friends[i]);
		}
		
		long count = 0;
		
		for (int i = 1; i <= MAX_LEN; i++) {
			for (int j = 0; j < friends[i].size(); j++) {
				int index = Collections.binarySearch(friends[i], friends[i].get(j) + K);
				
				if(index < 0)
					index = -index - 2;
				count += (index - j);
			}
		}
		
		bw.write(count + "\n");
		
		br.close();
		bw.close();
	}
}
