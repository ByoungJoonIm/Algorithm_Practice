package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q3054 {
	private static final int[][] frameAdder = {{0, 2}, {1, 1}, {1, -1}, {2, 0}, {-2, 0}, {-1, 1}, {-1, -1}, {0, -2}};
	private static final char SHOP = '#';
	private static final char STAR = '*';
	private static final char DOT = '.';
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String word = br.readLine();
		char map[][] = new char[5][5 + (word.length() - 1) * 4];
		
		for (int i = 0; i < map.length; i++)
			Arrays.fill(map[i], DOT);
		
		
		for (int i = 0; i < word.length(); i++) {
			int row = 2;
			int col = 2 + i * 4;
			
			boolean isWendy = (i + 1) % 3 == 0;
			
			map[row][col] = word.charAt(i);
			for (int j = 0; j < frameAdder.length; j++) {
				int nextRow = row + frameAdder[j][0];
				int nextCol = col + frameAdder[j][1];
				
				if(isWendy){
					map[nextRow][nextCol] = STAR;
				} else {
					if(map[nextRow][nextCol] == DOT)
						map[nextRow][nextCol] = SHOP;
				}
			}
		}
		
		for (int i = 0; i < map.length; i++)
			bw.write(new String(map[i]) + "\n");
		
		br.close();
		bw.close();
	}
}
