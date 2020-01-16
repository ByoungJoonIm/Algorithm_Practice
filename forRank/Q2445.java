package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2445 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = -n + 1; i < n; i++) {
			for (int j = 0; j < n - Math.abs(i); j++)
				bw.write("*");
			for (int j = 0; j < Math.abs(i) * 2; j++)
				bw.write(" ");
			for (int j = 0; j < n - Math.abs(i); j++)
				bw.write("*");
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
