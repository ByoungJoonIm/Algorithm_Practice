package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2909 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());	//»çÅÁ °¡°Ý
		int K = Integer.parseInt(st.nextToken());	//0ÀÇ °¹¼ö
		
		int unit = (int)Math.pow(10, K);
		double result = Math.round((double)C / unit);
		
		bw.write((int)result * unit + "\n");
		
		br.close();
		bw.close();
	}
}
