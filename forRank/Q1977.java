package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1977 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int rootM = (int)Math.sqrt(M - 1) + 1;
		int rootN = (int)Math.sqrt(N);
		int sum = 0;
		
		for (int i = rootM; i <= rootN; i++) {
			int power = (int)Math.pow(i, 2);
			sum += power;
		}

		if(sum == 0)
			bw.write("-1\n");
		else
			bw.write(sum + "\n" + (rootM * rootM) + "\n");
		
		br.close();
		bw.close();
	}
}
