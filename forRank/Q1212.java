package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1212 {
	private static final String converter[] = {"000", "001", "010", "011", "100", "101", "110", "111"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String oct = br.readLine();
	
		StringBuilder sb = new StringBuilder();
		
		if(oct.length() == 1 && Integer.parseInt(oct) == 0){
			sb.append(0);
		} else {
			for (int i = 0; i < oct.length(); i++) {
				sb.append(converter[oct.charAt(i) - '0']);
			}
			while(sb.charAt(0) == '0')
				sb.deleteCharAt(0);
		}
		
		bw.write(sb.toString() + "\n");
		
		br.close();
		bw.close();
	}
}
