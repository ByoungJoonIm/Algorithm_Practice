package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1022 {
	private static final int[] xAdder = {1, 0, -1, 0};
	private static final int[] yAdder = {0, -1, 0, 1};
	
	private static String pack(int number, int len){
		StringBuilder num = new StringBuilder(Integer.toString(number));
		
		while(num.length() < len){
			num.insert(0, ' ');
		}
		
		return num.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int mappedArray[][] = new int[r2 - r1 + 1][c2 - c1 + 1];
		int remainFactor = (r2 - r1 + 1) * (c2 - c1 + 1);
		
		int x = 0;
		int y = 0;
		int value = 1;
		int selector = 0;
		int sectionLen = 1;
		int sectionCounter = 0;
		
		while(remainFactor > 0){
			if(c1 <= x && x <= c2 && r1 <= y && y <= r2){
				mappedArray[y - r1][x - c1] = value;
				remainFactor--;
			}
			
			value++;
			sectionCounter++;
			x += xAdder[selector];
			y += yAdder[selector];
			
			if(sectionLen == sectionCounter){
				if((selector + 1) % 2 == 0)
					sectionLen++;
				selector = (selector + 1) % 4;
				sectionCounter = 0;
			}
		}
		
		value--;	//It is max Value
		
		int maxNumberLen = Integer.toString(value).length();

		for (int i = 0; i < r2 - r1 + 1; i++) {
			for (int j = 0; j < c2 - c1 + 1; j++)
				bw.write(pack(mappedArray[i][j], maxNumberLen) + " ");
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
