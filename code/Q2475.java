package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int powSum = 0;
		
		for (int i = 0; i < 5; i++) {
			int temp = Integer.parseInt(st.nextToken());
			powSum += (int)Math.pow(temp, 2);
		}
		
		bw.write(powSum % 10 + "\n");
		
		br.close();
		bw.close();
	}
}
