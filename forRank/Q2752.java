package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2752 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = {Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())};
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length - 1; i++)
			sb.append(arr[i]).append(' ');
		sb.append(arr[arr.length - 1]).append('\n');
		
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}
