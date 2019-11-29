package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q2587 {
	public static void main(String[] args) throws IOException{
		final int NUMOFNUMBERS = 5;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int arr[] = new int[NUMOFNUMBERS];
		int sum = 0;
		for (int i = 0; i < NUMOFNUMBERS; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		bw.write((sum / 5) + "\n");
		bw.write(arr[NUMOFNUMBERS / 2] + "\n");
		
		br.close();
		bw.close();
	}
}
