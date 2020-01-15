package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Q3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for (int i = 0; i < 10; i++) {
			int number = Integer.parseInt(br.readLine()) % 42;
			
			if(!hs.contains(number))
				hs.add(number);
		}
		
		bw.write(hs.size() + "\n");
		
		br.close();
		bw.close();
	}
}
