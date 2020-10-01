package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10162 {
	private static String getResult(int time){
		if(time % 10 != 0)
			return "-1";
		
		StringBuilder sb = new StringBuilder();
		sb.append(time / 300).append(' ');
		time %= 300;
		sb.append(time / 60).append(' ');
		time %= 60;
		sb.append(time / 10);
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(getResult(Integer.parseInt(br.readLine())) + "\n");
		
		br.close();
		bw.close();
	}
}
