package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String ox = br.readLine();
			int subCounter = 0;
			int subSum = 0;
			
			for (int j = 0; j < ox.length(); j++) {
				char ch = ox.charAt(j);
				
				if(ch == 'O')
					subSum += ++subCounter;
				else
					subCounter = 0;
			}
			bw.write(subSum + "\n");
		}
		
		br.close();
		bw.close();
	}
}
