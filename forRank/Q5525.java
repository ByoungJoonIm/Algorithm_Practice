package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int counter = 0;
		
		for (int i = 0; i < M; i++) {
			char c = S.charAt(i);
			
			if(c == 'I'){
				int j = i + 1;
				for (; j < M; j++) {
					if(c != S.charAt(j))
						c = S.charAt(j);
					else
						break;
				}
				
				j--;
				
				int validLen = (j - i) / 2 + 1;
				
				if(validLen > N){
					counter += (validLen - N);
				}
				
				if(i < j)
					i = j;
			}
		}
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
