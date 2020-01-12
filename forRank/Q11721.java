package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11721 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		
		for (int i = 0; i < str.length() / 10 + 1; i++) {
			int endIndex = i * 10 + 10;
			endIndex = Math.min(endIndex, str.length());
			bw.write(str.substring(i * 10, endIndex) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
