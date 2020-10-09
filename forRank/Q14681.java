package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q14681 {
	private static int getResult(int x, int y){
		if(y > 0){
			if(x > 0)
				return 1;
			return 2;
		}
		if(x > 0)
			return 4;
		return 3;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		bw.write(getResult(x, y) + "\n");
		
		br.close();
		bw.close();
	}
}
