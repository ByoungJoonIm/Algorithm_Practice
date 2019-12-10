package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q7567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		char beforeChar = ' ';
		int height = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == beforeChar)
				height += 5;
			else
				height += 10;
			
			beforeChar = ch;
		}
		
		bw.write(height + "\n");
		
		br.close();
		bw.close();
	}
}
