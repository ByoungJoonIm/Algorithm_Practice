package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10768 {
	private static String getResult(int month, int day){
		if(month == 2){
			if(day == 18)
				return "Special";
			if(day < 18)
				return "Before";
			return "After";
		}
			
		if(month < 2)
			return "Before";
		return "After";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int month = Integer.parseInt(br.readLine());
		int day = Integer.parseInt(br.readLine());
		
		bw.write(getResult(month, day) + "\n");
		
		br.close();
		bw.close();
	}
}
