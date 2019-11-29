package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int numbers[] = new int[2];
		int rs;
		
		for (int i = 0; i < 2; i++)
			numbers[i] = Integer.parseInt(br.readLine());
			
		rs = numbers[0] * numbers[1];
		while(numbers[1] > 0){
			int rest = numbers[1] % 10;
			bw.write((numbers[0] * rest) + "\n");
			numbers[1] /= 10;
		}
		bw.write(rs + "\n");
		
		br.close();
		bw.close();
	}
}
