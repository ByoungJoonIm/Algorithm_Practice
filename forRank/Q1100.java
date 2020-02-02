package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1100 {
	private static final int SIZE = 8;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int counter = 0;
		
		for (int i = 0; i < SIZE; i++) {
			String line = br.readLine();
			for (int j = i % 2; j < SIZE; j += 2) {
				if(line.charAt(j) == 'F')
					counter++;
			}
		}
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
