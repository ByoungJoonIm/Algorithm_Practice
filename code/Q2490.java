package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2490 {
	private static char play(String str){
		StringTokenizer st = new StringTokenizer(str);
		int sum = 0;
		
		for (int i = 0; i < 4; i++)
			sum += Integer.parseInt(st.nextToken());

		switch(sum){
		case 0:
		case 1:
		case 2:
		case 3:
			return (char)('D' - sum);
		case 4:
			return 'E';
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 3; i++)
			bw.write(play(br.readLine()) + "\n");
		
		br.close();
		bw.close();
	}
}
