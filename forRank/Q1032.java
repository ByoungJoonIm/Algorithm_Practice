package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1032 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String standard = br.readLine();
		int stringLen = standard.length();
		int histogram[] = new int[stringLen];
		
		for (int i = 1; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < stringLen; j++) {
				if(str.charAt(j) == standard.charAt(j))
					histogram[j]++;
			}
		}
		
		for (int i = 0; i < stringLen; i++) {
			if(histogram[i] + 1 == N)
				bw.write(standard.charAt(i));
			else
				bw.write("?");
		}
		
		br.close();
		bw.close();
	}
}
