package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int maxGroup = Math.min(F / 2, M);
		int restPeople = F - maxGroup * 2 + M - maxGroup;
		
		if(restPeople < K){
			K -= restPeople;
			K = (K + 2) / 3;
			maxGroup = Math.max(0, maxGroup - K);
		}

		bw.write(maxGroup + "\n");
		
		br.close();
		bw.close();
	}
}
