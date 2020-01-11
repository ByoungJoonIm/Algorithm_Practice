package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10817 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numbers[] = new int[3];
		
		for (int i = 0; i < 3; i++)
			numbers[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(numbers);
		
		bw.write(numbers[1] + "\n");
		
		br.close();
		bw.close();
	}
}
