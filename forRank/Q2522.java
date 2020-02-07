package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = -(N - 1); i < N; i++) {
			for (int j = 0; j < Math.abs(i); j++)
				bw.write(" ");
			for (int j = 0; j < N - Math.abs(i); j++)
				bw.write("*");
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
