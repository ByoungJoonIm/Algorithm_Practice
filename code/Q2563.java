package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2563 {
	private static final int DRAWING_PAPER_SIZE = 100;
	private static final int COLORED_PAPER_SIZE = 10;
	private static boolean attached[][];
	
	private static void attach(int x, int y){
		for (int i = 0; i < COLORED_PAPER_SIZE; i++) {
			for (int j = 0; j < COLORED_PAPER_SIZE; j++) {
				attached[x + i][y + j] = true;
			}
		}
	}
	
	private static int getArea(){
		int area = 0;
		for (int i = 1; i < DRAWING_PAPER_SIZE; i++) {
			for (int j = 1; j < DRAWING_PAPER_SIZE; j++) {
				if(attached[i][j])
					area++;
			}
		}
		return area;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		attached = new boolean[DRAWING_PAPER_SIZE][DRAWING_PAPER_SIZE];
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			attach(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		bw.write(getArea() + "\n");
		
		br.close();
		bw.close();
	}
}
