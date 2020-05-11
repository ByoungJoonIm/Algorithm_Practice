package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q9324 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String message = br.readLine();
			
			boolean isValid = true;
			int histogram[] = new int[26];
			
			for (int j = 0; j < message.length() && isValid; j++) {
				char cur = message.charAt(j);
				
				histogram[cur - 'A']++;
				if(histogram[cur - 'A'] % 3 == 0){
					if(j + 1 >= message.length())
						isValid = false;
					else {
						if(message.charAt(j + 1) == cur)
							j++;
						else
							isValid = false;
					}
				}
			}
			
			if(isValid)
				bw.write("OK\n");
			else
				bw.write("FAKE\n");
		}
		
		br.close();
		bw.close();
	}
}
