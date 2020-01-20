package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2902 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		StringBuilder rs = new StringBuilder();
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			if(ch >= 'A' && ch <= 'Z')
				rs.append(ch);
		}
		
		bw.write(rs.toString() + "\n");
		
		br.close();
		bw.close();
	}
}
