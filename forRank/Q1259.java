package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String line = br.readLine();
			
			if(line.length() == 1 && line.charAt(0) == '0')
				break;
			
			int left = 0;
			int right = line.length() - 1;
			boolean isRight = true;
			
			while(left < right && isRight){
				if(line.charAt(left) != line.charAt(right))
					isRight = false;
				left++;
				right--;
			}
			
			if(isRight)
				sb.append("yes");
			else
				sb.append("no");
			sb.append('\n');
		}
		
		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}
