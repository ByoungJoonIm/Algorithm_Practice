package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q6778 {
	private static String getResult(int antenna, int eyes){
		StringBuilder sb = new StringBuilder();
		if(antenna >= 3 && eyes <= 4)
			sb.append("TroyMartian\n");
		if(antenna <= 6 && eyes >= 2)
			sb.append("VladSaturnian\n");
		if(antenna <= 2 && eyes <= 3)
			sb.append("GraemeMercurian\n");
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int antenna = Integer.parseInt(br.readLine());
		int eyes = Integer.parseInt(br.readLine());
		
		bw.write(getResult(antenna, eyes));
		
		br.close();
		bw.close();
	}
}
