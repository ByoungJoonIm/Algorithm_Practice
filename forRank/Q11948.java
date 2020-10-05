package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Q11948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int science[] = new int[] {
				Integer.parseInt(br.readLine()),
				Integer.parseInt(br.readLine()),
				Integer.parseInt(br.readLine()),
				Integer.parseInt(br.readLine())	
		};
		
		int history[] = new int[] {
				Integer.parseInt(br.readLine()),
				Integer.parseInt(br.readLine())
		};
		
		Arrays.sort(science);
		Arrays.sort(history);
		
		int sum = science[1] + science[2] + science[3] + history[1];
		
		bw.write(sum + "\n");
		
		
		
		br.close();
		bw.close();
	}
}
