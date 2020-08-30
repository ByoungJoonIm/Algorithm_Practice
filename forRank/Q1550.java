package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1550 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		String line = br.readLine();
		
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(line.length() - 1 - i);
			int convC = c >= 'A' && c <= 'F' ? c - 'A' + 10 : c - '0';
			sum += (int)Math.pow(16, i) * convC;
		}

		bw.write(sum + "\n");
		
		br.close();
		bw.close();
	}
}
