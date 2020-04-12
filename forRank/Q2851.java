package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		int prev = 0;
		String str;
		
		while(sum < 100 && (str = br.readLine()) != null){
			prev = Integer.parseInt(str);
			sum += prev;
		}
		
		if(Math.abs(100 - sum) <= Math.abs(100 - (sum - prev))){
			bw.write(sum + "\n");
		} else{
			bw.write((sum - prev) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
