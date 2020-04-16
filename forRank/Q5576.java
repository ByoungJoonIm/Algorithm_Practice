package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Q5576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int universityW[] = new int[10];
		int universityK[] = new int[10];
		int sumW = 0;
		int sumK = 0;
		
		for (int i = 0; i < 10; i++)
			universityW[i] = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 10; i++)
			universityK[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(universityW);
		Arrays.sort(universityK);
		
		for (int i = 0; i < 3; i++) {
			sumW += universityW[9 - i];
			sumK += universityK[9 - i];
		}
		
		bw.write(sumW + " " + sumK + "\n");
		
		br.close();
		bw.close();
	}
}
