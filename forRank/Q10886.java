package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10886 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int cuteCounter = 0;
		int notCuteCounter = 0;
		
		for (int i = 0; i < n; i++) {
			if(Integer.parseInt(br.readLine()) == 0)
				notCuteCounter++;
			else
				cuteCounter++;
		}
		
		if(cuteCounter >= notCuteCounter)
			bw.write("Junhee is cute!\n");
		else
			bw.write("Junhee is not cute!\n");
		
		br.close();
		bw.close();
	}
}
