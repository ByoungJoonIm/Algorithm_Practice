package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long S = Long.parseLong(br.readLine());
		long i = 0;
		
		while(S >= 0){
			S -= ++i;
		}
		
		bw.write(--i + "\n");
		
		br.close();
		bw.close();
	}
}
