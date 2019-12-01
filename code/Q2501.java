package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> aliquot = new ArrayList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			if(N % i == 0)
				aliquot.add(i);
		}
		
		if(K - 1 < aliquot.size())
			bw.write(aliquot.get(K - 1) + "\n");
		else
			bw.write(0 + "\n");
		
		br.close();
		bw.close();
	}
}
