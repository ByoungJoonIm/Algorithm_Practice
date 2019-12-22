package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String words[] = new String[5];
		int lens[] = new int[5];
		StringBuilder sb = new StringBuilder();
		int maxLen = 0;
		
		for (int i = 0; i < 5; i++){
			words[i] = br.readLine();
			lens[i] = words[i].length();
			maxLen = Math.max(lens[i], maxLen);
		}
			
		for (int i = 0; i < maxLen; i++) {
			for (int j = 0; j < 5; j++) {
				if(i < lens[j])
					sb.append(words[j].charAt(i));
			}
		}
		
		bw.write(sb.toString() + "\n");
		
		br.close();
		bw.close();
	}
}
