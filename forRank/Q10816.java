package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			hm.computeIfPresent(number, (key, value)->++value);
			hm.putIfAbsent(number, 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			if(hm.containsKey(number))
				bw.write(hm.get(number) + " ");
			else
				bw.write("0 ");
		}
		
		bw.write("\n");
		
		br.close();
		bw.close();
	}
}
