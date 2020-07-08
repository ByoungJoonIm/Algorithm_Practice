package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q15829 {
	private static final int r = 31;
	private static final int M = 1234567891;
	
	private static long getPow(int i){
		if(i == 0)
			return 1;
		if(i == 1)
			return r;
		else
			return getPow(i - 1) * r % M;
	}
	
	private static long hashCode(String line){
		long hash = 0;
		
		for (int i = 0; i < line.length(); i++) {
			int value = line.charAt(i) - 'a' + 1;
			
			hash += ((getPow(i) % M) * (value )) % M;
			hash %= M;
		}
		
		return hash;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int L = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		bw.write(hashCode(line) + "\n");
		
		br.close();
		bw.close();
	}
}
