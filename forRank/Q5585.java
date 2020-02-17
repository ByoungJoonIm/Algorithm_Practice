package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q5585 {
	private static final int paid = 1000;
	private static final int changes[] = {500, 100, 50, 10, 5, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int money = paid - Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 0; i < changes.length; i++) {
			if(money / changes[i] > 0){
				cnt += (money / changes[i]);
				money %= changes[i];
			}
		}
		
		bw.write(cnt + "\n");
		
		br.close();
		bw.close();
	}
}
