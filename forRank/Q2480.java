package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2480 {
	private static int getResult(String line){
		StringTokenizer st = new StringTokenizer(line);
		int histogram[] = new int[7];
		
		while(st.hasMoreTokens()){
			int value = Integer.parseInt(st.nextToken());
			histogram[value]++;
		}
		
		int maxIndex = 0;
		for (int i = 6; i >= 1; i--) {
			if(histogram[i] > histogram[maxIndex]){
				maxIndex = i;
			}
		}
		
		if(histogram[maxIndex] == 3)
			return 10000 + maxIndex * 1000;
		if(histogram[maxIndex] == 2)
			return 1000 + maxIndex * 100;
		return maxIndex * 100;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(getResult(br.readLine()) + "\n");

		br.close();
		bw.close();
	}
}
