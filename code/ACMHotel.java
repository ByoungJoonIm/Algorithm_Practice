package mathmatics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ACMHotel {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			String rs = "";
			int floor = ((N - 1) % H) + 1;
			int roomNum = (N - 1) / H + 1;
			
			rs += floor;
			if(roomNum < 10)
				rs += '0';
			rs += roomNum;
			
			bw.write(rs + "\n");	
		}
		
		br.close();
		bw.close();
	}
}
