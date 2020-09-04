package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11655 {
	private static final int ROTATE = 13;
	
	private static char getCriptoChar(char c){
		int weight = ROTATE;
		
		int lower = c - 'a';
		int upper = c - 'A';
		
		if((ROTATE <= lower && lower < ROTATE * 2) || (ROTATE <= upper && upper < ROTATE * 2 ))
			weight = -weight;

		if(!Character.isAlphabetic(c))
			weight = 0;
			
		return (char)(c + weight);
	}

	private static String getResult(String origin){
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < origin.length(); i++) {
			sb.append(getCriptoChar(origin.charAt(i)));
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String origin = br.readLine();

		bw.write(getResult(origin) + "\n");
		
		br.close();
		bw.close();
	}
}
