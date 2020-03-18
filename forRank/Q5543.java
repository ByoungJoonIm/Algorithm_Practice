package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q5543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int minBurger = Integer.MAX_VALUE;
		int minBeverage = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			minBurger = Math.min(minBurger, Integer.parseInt(br.readLine()));
		}
		
		for (int i = 0; i < 2; i++) {
			minBeverage = Math.min(minBeverage, Integer.parseInt(br.readLine()));
		}
		
		bw.write((minBurger + minBeverage - 50) + "\n");
		
		br.close();
		bw.close();
	}
}
