package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2530 {
	private static final int ONE_DAY = 24 * 60 * 60;
	private static final int HOUR = 3600;
	private static final int MIN = 60;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int cookTime = Integer.parseInt(br.readLine());
		
		int absTime = A * HOUR + B * MIN + C;
		int afterCookTime = (absTime + cookTime) % ONE_DAY;

		int hour = afterCookTime / HOUR;
		int min = (afterCookTime % HOUR) / MIN;
		int sec = afterCookTime % 60;
		
		bw.write(hour + " " + min + " " + sec + "\n");
		
		br.close();
		bw.close();
	}
}
