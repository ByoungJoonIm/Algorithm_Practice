package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q16479 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D1 = Integer.parseInt(st.nextToken());
		int D2 = Integer.parseInt(st.nextToken());
		
		double H = Math.pow(K, 2) - Math.pow(Math.abs(D1 - D2) / 2.0, 2);
		
		bw.write(H + "\n");
		
		br.close();
		bw.close();
	}
}
