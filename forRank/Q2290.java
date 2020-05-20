package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2290 {
	private static final char VERTICAL = '|';
	private static final char HORIZONTAL = '-';
	private static final char SPACE = ' ';
	
	private static final boolean DISPLAY[][] = {
			{true, true, true, false, true, true, true},		//0
			{false, false, true, false, false, true, false},	//1
			{true, false, true, true, true, false, true},		//2
			{true, false, true, true, false, true, true},		//3
			{false, true, true, true, false, true, false},		//4
			{true, true, false, true, false, true, true},		//5
			{true, true, false, true, true, true, true},		//6
			{true, false, true, false, false, true, false},		//7
			{true, true, true, true, true, true, true},			//8
			{true, true, true, true, false, true, true}			//9
	};
	
	private static void horizontal(int numbers[], int s, StringBuilder sb, int location){
		for (int i = 0; i < numbers.length; i++) {
			sb.append(SPACE);
			for (int j = 0; j < s; j++) {
				if(DISPLAY[numbers[i]][location])
					sb.append(HORIZONTAL);
				else
					sb.append(SPACE);
			}
			sb.append(SPACE);
			sb.append(SPACE);
		}
	}
	
	private static void vertical(int numbers[], int s, StringBuilder sb[], int startIndex, int locationLeft, int locationRight){
		for (int i = 0; i < numbers.length; i++) {
			for (int j = startIndex; j < startIndex + s; j++) {
				if(DISPLAY[numbers[i]][locationLeft])
					sb[j].append(VERTICAL);
				else
					sb[j].append(SPACE);
				for (int k = 0; k < s; k++)
					sb[j].append(SPACE);
				
				if(DISPLAY[numbers[i]][locationRight])
					sb[j].append(VERTICAL);
				else
					sb[j].append(SPACE);
				sb[j].append(SPACE);
			}
		}
	}
	
	private static String[] getDisplay(int s, String display){
		StringBuilder sb[] = new StringBuilder[2 * s + 3];
		int numbers[] = new int[display.length()];
		String result[] = new String[2 * s + 3];
		
		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuilder();
		
		for (int i = 0; i < display.length(); i++)
			numbers[i] = display.charAt(i) - '0';
		
		horizontal(numbers, s, sb[0], 0);			//0
		vertical(numbers, s, sb, 1, 1, 2);			//1, 2
		horizontal(numbers, s, sb[s + 1], 3);		//3
		vertical(numbers, s, sb, s + 2, 4, 5);		//4, 5
		horizontal(numbers, s, sb[2 * s + 2], 6);	//6	
		
		for (int i = 0; i < result.length; i++)
			result[i] = sb[i].toString();
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String result[] = getDisplay(Integer.parseInt(st.nextToken()), st.nextToken());
		
		for (int i = 0; i < result.length; i++) {
			bw.write(result[i] + "\n");
		}
		
		br.close();
		bw.close();
	}
}
