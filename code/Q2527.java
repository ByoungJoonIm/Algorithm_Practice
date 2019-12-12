package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2527 {
	private static class Square{
		int x1;
		int x2;
		int y1;
		int y2;
		
		public Square(String x, String y, String p, String q){
			this.x1 = Integer.parseInt(x);
			this.x2 = Integer.parseInt(p);
			this.y1 = Integer.parseInt(y);
			this.y2 = Integer.parseInt(q);
		}
		
		private static char compare(Square a, Square b){
			if((a.x2 < b.x1) || a.x1 > b.x2 || a.y2 < b.y1 || a.y1 > b.y2)
				return 'd';
			if(a.x1 == b.x2 || a.x2 == b.x1){
				if(a.y1 == b.y2 || a.y2 == b.y1)
					return 'c';
				return 'b';
			}
			if(a.y1 == b.y2 || a.y2 == b.y1){
				return 'b';
			}
			return 'a';
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			bw.write(Square.compare(
					new Square(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()),
					new Square(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken())) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
