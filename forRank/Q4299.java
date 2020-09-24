package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q4299 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//A + B = x, A - B = y
		//x + y = 2A
		//A = (x + y) / 2
		//B = (x - y) / 2
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		if((x + y) % 2 == 0 && (x - y) % 2 == 0 && x >= y){
			int A = (x + y) / 2;
			int B = (x - y) / 2;
			
			if(A < B){
				int temp = A;
				A = B;
				B = temp;
			}
			bw.write(A + " " + B + "\n");
		} else
			bw.write(-1 + "\n");
		
		br.close();
		bw.close();
	}
}
