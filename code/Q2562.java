package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2562 {
	private static final int NUMOFNUMBERS = 9;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max = 0;
		int maxOrder = 0;
		
		for (int i = 1; i <= NUMOFNUMBERS; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp > max){
				max = temp;
				maxOrder = i;
			}
		}
		bw.write(max + "\n" + maxOrder + "\n");
		
		br.close();
		bw.close();
	}
}
