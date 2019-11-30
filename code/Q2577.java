package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int mult = 1;
		int histogram[] = new int[10];
		
		for (int i = 0; i < 3; i++)
			mult *= Integer.parseInt(br.readLine());
			
		while(mult > 0){
			histogram[mult % 10]++;
			mult /= 10;
		}
		
		for (int i = 0; i < 10; i++)
			bw.write(histogram[i] + "\n");
		
		br.close();
		bw.close();
	}
}
