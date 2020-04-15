package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q3034 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int maxLen = (int)Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		
		for (int i = 0; i < N; i++) {
			int length = Integer.parseInt(br.readLine());
			if(length <= maxLen)
				bw.write("DA\n");
			else
				bw.write("NE\n");
		}
		
		br.close();
		bw.close();
	}
}
