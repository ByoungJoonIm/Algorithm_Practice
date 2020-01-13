package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2884 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		int totalMinute = hour * 60 + minute;
		int alamTime = totalMinute - 45;
		
		if(alamTime < 0)
			alamTime += 1440;
		
		bw.write(String.format("%d %d\n", alamTime / 60, alamTime % 60));
		
		br.close();
		bw.close();
	}
}
