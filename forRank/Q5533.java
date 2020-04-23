package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q5533 {
	private static final int ROUND = 3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int submmitedScores[][] = new int[n][ROUND];
		int playerScore[] = new int[n];
		
		HashMap<Integer, Boolean> hm;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < ROUND; j++)
				submmitedScores[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < ROUND; i++) {
			hm = new HashMap<Integer, Boolean>();
			
			for (int j = 0; j < n; j++) {
				hm.computeIfPresent(submmitedScores[j][i], (Integer key, Boolean value) -> false);
				hm.putIfAbsent(submmitedScores[j][i], true);
			}
			
			for (int j = 0; j < n; j++) {
				if(hm.get(submmitedScores[j][i]))
					playerScore[j] += submmitedScores[j][i];
			}
		}
		
		for (int i = 0; i < n; i++)
			bw.write(playerScore[i] + "\n");
		
		br.close();
		bw.close();
	}
}
