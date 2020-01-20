package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int alpha[] = new int[26];
		
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++)
			alpha[str.charAt(i) - 'a']++;
		
		for (int i = 0; i < 26; i++)
			bw.write(String.format("%d ", alpha[i]));
		
		bw.write("\n");
			
		br.close();
		bw.close();
	}
}
