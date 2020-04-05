package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1159 {
	private static final int ALPHABET_LENGTH = 26;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int histogram[] = new int[26];
		int n = Integer.parseInt(br.readLine());
		boolean moreThanOne = false;
		
		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			histogram[name.charAt(0) - 'a']++;
		}
		
		for (int i = 0; i < ALPHABET_LENGTH; i++) {
			if(histogram[i] >= 5){
				bw.write((char)(i + 'a'));
				moreThanOne = true;
			}
		}
		
		if(!moreThanOne)
			bw.write("PREDAJA\n");
		
		
		br.close();
		bw.close();
	}
}
