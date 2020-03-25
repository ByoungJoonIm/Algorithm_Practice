package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q5565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int total = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 9; i++) {
			int bookPrice = Integer.parseInt(br.readLine());
			total -= bookPrice;
		}
		
		bw.write(total + "\n");
		
		br.close();
		bw.close();
	}
}
