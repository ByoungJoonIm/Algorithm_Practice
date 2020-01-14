package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10818 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = -Integer.MAX_VALUE + 1;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			max = Math.max(max, number);
			min = Math.min(min, number);
		}
		
		bw.write(String.format("%d %d\n", min, max));
		
		br.close();
		bw.close();
	}
}
