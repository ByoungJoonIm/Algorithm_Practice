package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10871 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			if(number < target)
				bw.write(number + " ");
		}
		bw.write("\n");
		
		br.close();
		bw.close();
	}
}
