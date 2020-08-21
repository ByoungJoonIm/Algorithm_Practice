package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.ObjectInputStream.GetField;

public class Q1213 {
	private static int ALPHABET_SIZE = 26;
	private static int histogram[];
	
	private static String getResult(){
		//홀수인것은 최대 1개만 올수 있음
		int oddCounter = 0;
		char oddChar = 'A';
		
		for (int i = 0; i < histogram.length; i++) {
			if(histogram[i] % 2 == 1){
				oddCounter++;
				oddChar = (char)('A' + i);
			}
		}
		
		if(oddCounter >= 2){
			return "I'm Sorry Hansoo";
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < histogram.length; i++) {
			for (int j = 0; j < histogram[i] / 2; j++) {
				sb.append((char)('A' + i));
			}
		}
		
		if(oddCounter == 1)
			sb.append(oddChar);
		
		for (int i = ALPHABET_SIZE - 1; i >= 0; i--) {
			for (int j = 0; j < histogram[i] / 2; j++) {
				sb.append((char)('A' + i));
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		histogram = new int[ALPHABET_SIZE];
		
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++)
			histogram[line.charAt(i) - 'A']++;
		
		bw.write(getResult() + "\n");
		
		br.close();
		bw.close();
	}
}
