package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q5046 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<Integer> hotels = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//참가자 수
		int B = Integer.parseInt(st.nextToken());	//예산
		int H = Integer.parseInt(st.nextToken());	//호텔 수
		int W = Integer.parseInt(st.nextToken());	//선택 가능 주의 수
		
		for (int i = 0; i < H; i++) {
			int pricePerPerson = Integer.parseInt(br.readLine());
			boolean valid = B >= pricePerPerson * N;
			
			st = new StringTokenizer(br.readLine());

			if(valid){
				valid = false;
				for (int j = 0; j < W && !valid; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n >= N)
						valid = true;
				}
			}
			
			if(valid)
				hotels.add(pricePerPerson);
		}
		
		if(hotels.size() > 0){
			Collections.sort(hotels);
			bw.write(hotels.get(0) * N + "\n");
		} else {
			bw.write("stay home\n");
		}
		
		br.close();
		bw.close();
	}
}
