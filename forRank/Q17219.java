package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q17219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			hm.put(st.nextToken(), st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			bw.write(hm.get(br.readLine()) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
