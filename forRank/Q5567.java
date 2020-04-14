package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q5567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		boolean relation[][] = new boolean[n + 1][n + 1];
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int origin = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			relation[origin][dest] = true;
			relation[dest][origin] = true;
		}
		
		for (int i = 2; i <= n; i++) {
			if(relation[1][i]){
				hs.add(i);
				for (int j = 2; j <= n; j++) {
					if(relation[i][j])
						hs.add(j);
				}
			}
		}
		
		bw.write(hs.size() + "\n");
		
		br.close();
		bw.close();
	}
}
