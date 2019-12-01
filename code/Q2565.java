package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2565 {
	private static final int MAX_POSITION_SIZE = 500;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int lines[] = new int[MAX_POSITION_SIZE + 1];
		int lis[] = new int[MAX_POSITION_SIZE + 1];
		int maxLen = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lines[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= MAX_POSITION_SIZE; i++) {
			if (lines[i] > 0) {
				lis[i] = 1;
				for (int j = 1; j < i; j++) {
					if (lines[i] > lines[j] && lis[i] < lis[j] + 1)
						lis[i] = lis[j] + 1;
				}
				maxLen = Math.max(maxLen, lis[i]);
			}
		}

		bw.write((N - maxLen) + "\n");

		br.close();
		bw.close();
	}
}
