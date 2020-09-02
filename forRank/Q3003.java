package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q3003 {
	private static final int right[] = {1, 1, 2, 2, 2, 8};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < right.length; i++) {
			int cur = Integer.parseInt(st.nextToken());
			bw.write((right[i] - cur) + " ");
		}
		bw.write("\n");
		
		br.close();
		bw.close();
	}
}
